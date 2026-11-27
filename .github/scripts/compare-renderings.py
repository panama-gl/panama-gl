#!/usr/bin/env python3
"""
Compare the renderings of the reference scene made by TestBackendRendering on each backend.

Usage : compare-renderings.py <renderings dir> <output dir>

Reads every <name>.png and its <name>.properties under the renderings dir (recursively), then
writes to the output dir :
- comparison.png : the renderings side by side, labelled with OS, CPU, context, backend, renderer
  and time per frame ;
- diff/<name>.png : the pixels differing from the reference rendering, in red ;
- comparison.md : a markdown table, also appended to $GITHUB_STEP_SUMMARY when set.

The reference is the rendering of Mesa llvmpipe through GLX on Linux x86_64 when present, as it is
a plain OpenGL implementation that runs on any CI runner.
"""
import os
import sys
from pathlib import Path

from PIL import Image, ImageChops, ImageDraw, ImageFont

THRESHOLD = 16  # a pixel differs when a channel differs by more than this
REFERENCE_KEYS = ["linux-x86_64__glx__cpu-llvmpipe", "linux-x86_64__egl__cpu-llvmpipe"]

# Order of the backends in the comparison : plain OpenGL first, then OpenGL layered over other APIs
BACKEND_ORDER = ["cpu-llvmpipe", "opengl-native", "apple-opengl", "apple-opengl-metal",
                 "vulkan-zink", "vulkan-zink-lavapipe", "vulkan-zink-moltenvk",
                 "vulkan-zink-kosmickrisp", "vulkan-zink-dozen", "d3d12", "d3d12-warp"]


def read_properties(path):
    props = {}
    for line in path.read_text(encoding="utf-8", errors="replace").splitlines():
        if line.startswith("#") or "=" not in line:
            continue
        key, value = line.split("=", 1)
        props[key.strip()] = value.strip().replace("\\:", ":").replace("\\=", "=").replace("\\ ", " ")
    return props


def font(size):
    for candidate in ["/usr/share/fonts/truetype/dejavu/DejaVuSans.ttf",
                      "/Library/Fonts/Arial.ttf", "C:/Windows/Fonts/arial.ttf"]:
        if os.path.exists(candidate):
            return ImageFont.truetype(candidate, size)
    try:
        return ImageFont.load_default(size)
    except TypeError:
        return ImageFont.load_default()


def diff_ratio(image, reference):
    if image.size != reference.size:
        return None, None
    diff = ImageChops.difference(image, reference)
    mask = diff.point(lambda v: 255 if v > THRESHOLD else 0).convert("L")
    # convert("L") averages channels : any channel above the threshold gives a non zero value
    differing = sum(1 for v in mask.getdata() if v > 0)
    overlay = Image.blend(reference, Image.new("RGB", reference.size, "white"), 0.7)
    overlay.paste(Image.new("RGB", reference.size, (220, 0, 0)), mask=mask)
    return differing / (image.size[0] * image.size[1]), overlay


def sort_key(item):
    p = item["props"]
    backend = p.get("backend", "")
    order = BACKEND_ORDER.index(backend) if backend in BACKEND_ORDER else len(BACKEND_ORDER)
    return (p.get("os", ""), p.get("arch", ""), order, p.get("context", ""))


def main(src, out):
    src, out = Path(src), Path(out)
    (out / "diff").mkdir(parents=True, exist_ok=True)

    items = []
    for props_file in sorted(src.rglob("*.properties")):
        png = props_file.with_suffix(".png")
        props = read_properties(props_file)
        failed = props.get("status") == "failed" or not png.exists()
        items.append({"name": props_file.stem, "png": png, "props": props, "failed": failed,
                      "image": None if failed else Image.open(png).convert("RGB")})
    rendered = [i for i in items if not i["failed"]]
    if not rendered:
        print("No rendering found in", src)
        return 1
    items.sort(key=sort_key)

    reference = next((i for k in REFERENCE_KEYS for i in rendered if k in i["name"]), rendered[0])
    items.remove(reference)
    items.insert(0, reference)
    size = reference["image"].size
    for item in items:
        if item["failed"]:
            item["diff"] = None
            tile = Image.new("RGB", size, (235, 235, 235))
            d = ImageDraw.Draw(tile)
            d.text((20, 20), "FAILED", fill=(170, 0, 0), font=font(28))
            error = item["props"].get("error", item["props"].get("version", ""))
            words, line, y = error.split(" "), "", 70
            for word in words:
                if len(line) + len(word) > 44:
                    d.text((20, y), line, fill=(60, 60, 60), font=font(15))
                    line, y = "", y + 22
                line = (line + " " + word).strip()
            d.text((20, y), line, fill=(60, 60, 60), font=font(15))
            item["image"] = tile
            continue
        ratio, overlay = diff_ratio(item["image"], reference["image"])
        item["diff"] = ratio
        if overlay is not None:
            overlay.save(out / "diff" / (item["name"] + ".png"))

    # Contact sheet : 3 columns of labelled renderings
    w, h = items[0]["image"].size
    cols = min(3, len(items))
    rows = (len(items) + cols - 1) // cols
    label_h, margin = 92, 12
    sheet = Image.new("RGB", (cols * (w + margin) + margin, rows * (h + label_h + margin) + margin + 40),
                      "white")
    draw = ImageDraw.Draw(sheet)
    title, bold, small = font(22), font(17), font(14)
    draw.text((margin, 10), "PanamaGL reference scene : the same OpenGL calls on each backend", fill="black",
              font=title)
    for n, item in enumerate(items):
        p = item["props"]
        x = margin + (n % cols) * (w + margin)
        y = 40 + margin + (n // cols) * (h + label_h + margin)
        sheet.paste(item["image"], (x, y))
        draw.rectangle([x, y, x + w - 1, y + h - 1], outline=(180, 180, 180))
        is_ref = item is reference
        diff = "reference" if is_ref else ("not rendered" if item["failed"] else (
            "size differs" if item["diff"] is None else f"{100 * item['diff']:.2f}% pixels differ"))
        draw.text((x, y + h + 4), f"{p.get('os')}-{p.get('arch')} / {p.get('context')} / {p.get('backend')}",
                  fill="black", font=bold)
        draw.text((x, y + h + 26), p.get("renderer", "")[:62], fill=(60, 60, 60), font=small)
        draw.text((x, y + h + 44), p.get("version", "")[:62], fill=(60, 60, 60), font=small)
        draw.text((x, y + h + 62), f"{p.get('ms.per.frame', '?')} ms per frame  -  {diff}",
                  fill=(170, 0, 0) if item["failed"] else (
                      (0, 90, 0) if is_ref or (item["diff"] or 0) < 0.01 else (170, 60, 0)), font=small)
    sheet.save(out / "comparison.png")

    lines = ["## Rendering backends", "",
             f"Reference : `{reference['name']}`. A pixel differs when a channel differs by more than {THRESHOLD}.",
             "", "| OS | CPU | Context | Backend | Renderer | OpenGL | ms / frame | Differing pixels | Image |",
             "|---|---|---|---|---|---|---|---|---|"]
    for item in items:
        p = item["props"]
        diff = "reference" if item is reference else ("**failed** : " + p.get("error", "")[:120]
            if item["failed"] else ("size differs" if item["diff"] is None else f"{100 * item['diff']:.2f} %"))
        lines.append(f"| {p.get('os')} | {p.get('arch')} | {p.get('context')} | **{p.get('backend')}** | "
                     f"{p.get('renderer')} | {p.get('version')} | {p.get('ms.per.frame')} | {diff} | "
                     f"`{item['name']}` |")
    lines += ["", "Images : artifact `rendering-comparison` (comparison.png, renderings, diff/)."]
    markdown = "\n".join(lines) + "\n"
    (out / "comparison.md").write_text(markdown, encoding="utf-8")
    summary = os.environ.get("GITHUB_STEP_SUMMARY")
    if summary:
        with open(summary, "a", encoding="utf-8") as f:
            f.write(markdown)
    print(markdown)
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 3:
        print(__doc__)
        sys.exit(2)
    sys.exit(main(sys.argv[1], sys.argv[2]))
