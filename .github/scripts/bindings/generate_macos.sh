#!/usr/bin/env bash
# Generate the macOS bindings of PanamaGL with jextract, as the scripts of
# panama-gl-bindings/scripts/macos do, but in packages without CPU name so
# that the bindings generated on x86_64 and ARM64 can be compared. jextract
# finds the headers and frameworks of the SDK given by xcrun.
#
# Usage : generate_macos.sh <jextract> <panama-gl-bindings/scripts/macos> <output dir>
set -euo pipefail

JEXTRACT=$(cd "$(dirname "$1")" && pwd)/$(basename "$1")
SCRIPTS=$(cd "$2" && pwd)
OUT=$(mkdir -p "$3" && cd "$3" && pwd)
echo "macOS SDK $(xcrun --show-sdk-version)" >> "$OUT/versions.txt"

generate() {
  local package=$1 header_class=$2 header=$3
  shift 3
  local log="$OUT/$package.log"
  "$JEXTRACT" --target-package "$package" --header-class-name "$header_class" --output "$OUT" \
    --dump-includes "$OUT/$package.includes" "$@" "$header" > "$log" 2>&1 \
    && "$JEXTRACT" --target-package "$package" --header-class-name "$header_class" --output "$OUT" \
    "$@" "$header" >> "$log" 2>&1 \
    || { grep -v warning "$log" | tail -40; echo "jextract failed for $package"; exit 1; }
}

cd "$SCRIPTS"
generate opengl.macos glut_h include_opengl.h --framework GLUT
generate glext.macos glext_h include_glext.h --framework OpenGL --framework GLUT
generate cgl.macos cgl_h include_cgl.h
