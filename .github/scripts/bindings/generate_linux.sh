#!/usr/bin/env bash
# Generate the Linux bindings of PanamaGL with jextract, as the scripts of
# panama-gl-bindings/scripts/linux do, but in packages without CPU name so
# that the bindings generated on x86_64 and ARM64 can be compared.
#
# Usage : generate_linux.sh <jextract> <panama-gl-bindings/scripts/linux> <output dir>
set -euo pipefail

JEXTRACT=$(cd "$(dirname "$1")" && pwd)/$(basename "$1")
SCRIPTS=$(cd "$2" && pwd)
OUT=$(mkdir -p "$3" && cd "$3" && pwd)
echo "Mesa headers $(dpkg-query -W -f '${Version}' mesa-common-dev), freeglut headers $(dpkg-query -W -f '${Version}' freeglut3-dev)" >> "$OUT/versions.txt"

generate() {
  local package=$1 header_class=$2 header=$3
  shift 3
  local log="$OUT/$package.log"
  "$JEXTRACT" --target-package "$package" --header-class-name "$header_class" --output "$OUT" \
    --dump-includes "$OUT/$package.includes" "$@" -I /usr/include/GL "$header" > "$log" 2>&1 \
    && "$JEXTRACT" --target-package "$package" --header-class-name "$header_class" --output "$OUT" \
    "$@" -I /usr/include/GL "$header" >> "$log" 2>&1 \
    || { grep -v warning "$log" | tail -40; echo "jextract failed for $package"; exit 1; }
}

generate opengl.linux glut_h /usr/include/GL/glut.h -lGL -lglut -lGLU -lGLEW
generate glext.linux glext_h "$SCRIPTS/include_glext.h" -lGL -lGLX
generate glx.linux glx_h /usr/include/GL/glx.h -lGL -lGLX
generate glxext.linux glxext_h "$SCRIPTS/include_glxext.h" -lGL -lGLX
