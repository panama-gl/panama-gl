#!/usr/bin/env bash
# Generate the function pointer types (PFNGL...PROC) and the constants of the Khronos glext.h with
# jextract, in package opengl.glext.
#
# Usage : generate_glext.sh <jextract> <dir containing GL/glext.h and KHR/khrplatform.h> <output dir>
set -euo pipefail

JEXTRACT=$1
KHRONOS=$(cd "$2" && pwd)
OUT=$(mkdir -p "$3" && cd "$3" && pwd)
HEADER=$(cd "$(dirname "$0")" && pwd)/include_glext.h

"$JEXTRACT" --dump-includes "$OUT/all.includes" -I "$KHRONOS" "$HEADER" > "$OUT/glext.log" 2>&1 \
  || { tail -40 "$OUT/glext.log"; exit 1; }
grep -E -e '--include-typedef PFNGL' -e '--include-constant GL_' "$OUT/all.includes" \
  | sed 's/ *#.*//' > "$OUT/glext.includes"
echo "$(grep -c typedef "$OUT/glext.includes") function pointer types, $(grep -c constant "$OUT/glext.includes") constants"
"$JEXTRACT" --target-package opengl.glext --header-class-name glext_h --output "$OUT" \
  @"$OUT/glext.includes" -I "$KHRONOS" "$HEADER" >> "$OUT/glext.log" 2>&1 \
  || { tail -40 "$OUT/glext.log"; exit 1; }
rm "$OUT/all.includes"
