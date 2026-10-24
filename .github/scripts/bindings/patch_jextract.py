#!/usr/bin/env python3
"""Patch the sources of jextract given as argument to run with the libclang of LLVM 16 and later.

Since LLVM 16, libclang spells the cursors of unnamed records "struct (unnamed at <file>:<line>:<column>)"
instead of an empty string. jextract then uses this spelling as a class name, which does not compile,
as a file name, invalid on Windows, and as a field name, which fails the layout of the anonymous
structs of winnt.h. Restore the empty spelling expected by jextract.
"""
import sys
from pathlib import Path
p = Path(sys.argv[1]) / 'src/main/java/org/openjdk/jextract/clang/Cursor.java'
s = p.read_text()
old = '''        var spelling = Index_h.clang_getCursorSpelling(LibClang.STRING_ALLOCATOR, segment);
        return LibClang.CXStrToString(spelling);'''
new = '''        var spelling = Index_h.clang_getCursorSpelling(LibClang.STRING_ALLOCATOR, segment);
        String name = LibClang.CXStrToString(spelling);
        return name.matches("(struct|union|enum) \\\\((unnamed|anonymous) at .*\\\\)") ? "" : name;'''
assert old in s, 'spelling() not found'
p.write_text(s.replace(old, new))
