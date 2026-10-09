#!/usr/bin/env python3
"""Report the platforms on which PanamaGL tests ran in CI.

Reads the artifacts downloaded from the build jobs, one folder per runner, each holding the
Surefire XML reports and the panamagl-platform.properties written by TestPlatformReport.

Writes a Markdown table of the platforms (OS, CPU, JVM, OpenGL) with their test results, and
checks that every PanamaGLFactory declared in the wrappers modules was selected on at least one
runner. Exits with 1 if a factory was not tested or if a runner has no platform report.

Usage : tested_platforms.py <artifacts dir> <services file>... [--output tested-platforms.md]
"""
import argparse
import glob
import os
import sys
import xml.etree.ElementTree as ET


def read_properties(path):
    props = {}
    with open(path, encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if not line or line.startswith("#") or "=" not in line:
                continue
            key, value = line.split("=", 1)
            props[key.strip()] = value.strip().replace("\\:", ":").replace("\\=", "=")
    return props


def count_tests(folder):
    total = {"tests": 0, "failures": 0, "errors": 0, "skipped": 0}
    for path in glob.glob(os.path.join(folder, "TEST-*.xml")):
        try:
            suite = ET.parse(path).getroot()
        except ET.ParseError:
            continue
        for key in total:
            total[key] += int(suite.get(key, "0"))
    return total


def declared_factories(service_files):
    factories = []
    for path in service_files:
        with open(path, encoding="utf-8") as f:
            factories += [l.strip() for l in f if l.strip() and not l.startswith("#")]
    return factories


def short(class_name):
    return class_name.rsplit(".", 1)[-1] if class_name else ""


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("artifacts")
    parser.add_argument("services", nargs="+")
    parser.add_argument("--output", default="tested-platforms.md")
    args = parser.parse_args()

    rows = []
    missing_reports = []
    for folder in sorted(glob.glob(os.path.join(args.artifacts, "*"))):
        if not os.path.isdir(folder):
            continue
        runner = os.path.basename(folder).replace("surefire-reports-", "")
        report = os.path.join(folder, "panamagl-platform.properties")
        props = read_properties(report) if os.path.exists(report) else {}
        if not props.get("gl.version"):
            missing_reports.append(runner)
        rows.append((runner, props, count_tests(folder)))

    factories = declared_factories(args.services)
    tested = {props.get("factory") for _, props, counts in rows
              if props.get("gl.version") and counts["failures"] + counts["errors"] == 0}
    untested = [f for f in factories if f not in tested]

    lines = ["## Platforms on which PanamaGL was tested", "",
             "| Runner | OS | CPU | JVM | Factory | OpenGL | Renderer | Tests | Failed | Skipped |",
             "|---|---|---|---|---|---|---|---|---|---|"]
    for runner, props, counts in rows:
        failed = counts["failures"] + counts["errors"]
        status = "✅" if failed == 0 and props.get("gl.version") else "❌"
        lines.append("| {} {} | {} {} | {} | {} {} | {} | {} | {} | {} | {} | {} |".format(
            status, runner,
            props.get("os.name", "?"), props.get("os.version", ""),
            props.get("os.arch", "?"),
            props.get("java.vendor", ""), props.get("java.version", "?"),
            short(props.get("factory")),
            props.get("gl.version", props.get("error", "no report")),
            props.get("gl.renderer", ""),
            counts["tests"], failed, counts["skipped"]))

    lines += ["", "### Factories", ""]
    for factory in factories:
        lines.append("- {} `{}`".format("✅" if factory in tested else "❌ not tested", short(factory)))
    if missing_reports:
        lines += ["", "Runners without platform report : " + ", ".join(missing_reports)]

    markdown = "\n".join(lines) + "\n"
    with open(args.output, "w", encoding="utf-8") as f:
        f.write(markdown)
    summary = os.environ.get("GITHUB_STEP_SUMMARY")
    if summary:
        with open(summary, "a", encoding="utf-8") as f:
            f.write(markdown)
    print(markdown)

    if untested or missing_reports:
        print("Untested factories : {}".format(", ".join(map(short, untested))), file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
