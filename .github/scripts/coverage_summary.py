#!/usr/bin/env python3
"""Report the test coverage of PanamaGL modules in CI.

Reads the artifacts downloaded from the build jobs, one folder per runner, each holding the
jacoco-<module>.csv reports written by the JaCoCo Maven plugin (generated GL wrappers excluded).

Writes a Markdown table of the line and branch coverage of each module on each runner. Platform
code (wrappers, contexts, FBO of an OS) only runs on its own OS, so each module is covered best
by the runners of its platform.

Usage : coverage_summary.py <artifacts dir> [--output coverage.md]
"""
import argparse
import csv
import glob
import os
import sys


def read_coverage(path):
    """Sum the line and branch counters of a JaCoCo CSV report."""
    total = {"LINE_COVERED": 0, "LINE_MISSED": 0, "BRANCH_COVERED": 0, "BRANCH_MISSED": 0}
    with open(path, encoding="utf-8") as f:
        for row in csv.DictReader(f):
            for key in total:
                total[key] += int(row[key])
    return total


def ratio(covered, missed):
    count = covered + missed
    if count == 0:
        return "-"
    return "{:.0f} % ({}/{})".format(100.0 * covered / count, covered, count)


def percent(covered, missed):
    count = covered + missed
    return "-" if count == 0 else "{:.0f} %".format(100.0 * covered / count)


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("artifacts")
    parser.add_argument("--output", default="coverage.md")
    args = parser.parse_args()

    # coverage[module][runner] = counters
    coverage = {}
    runners = []
    for folder in sorted(glob.glob(os.path.join(args.artifacts, "*"))):
        if not os.path.isdir(folder):
            continue
        runner = os.path.basename(folder).replace("surefire-reports-", "")
        reports = sorted(glob.glob(os.path.join(folder, "jacoco-*.csv")))
        if not reports:
            continue
        runners.append(runner)
        for report in reports:
            module = os.path.basename(report)[len("jacoco-"):-len(".csv")]
            coverage.setdefault(module, {})[runner] = read_coverage(report)

    lines = ["## Test coverage", "",
             "Lines covered by the tests of each module, on each runner, generated GL wrappers excluded.",
             "", "| Module | " + " | ".join(runners) + " |",
             "|---|" + "---|" * len(runners)]
    for module in sorted(coverage):
        cells = []
        for runner in runners:
            c = coverage[module].get(runner)
            if c is None:
                cells.append("not built")
            else:
                cells.append("{}, branches {}".format(
                    ratio(c["LINE_COVERED"], c["LINE_MISSED"]),
                    percent(c["BRANCH_COVERED"], c["BRANCH_MISSED"])))
        lines.append("| {} | {} |".format(module, " | ".join(cells)))

    if not runners:
        lines += ["", "No coverage report found."]

    markdown = "\n".join(lines) + "\n"
    with open(args.output, "w", encoding="utf-8") as f:
        f.write(markdown)
    summary = os.environ.get("GITHUB_STEP_SUMMARY")
    if summary:
        with open(summary, "a", encoding="utf-8") as f:
            f.write(markdown)
    print(markdown)
    return 0


if __name__ == "__main__":
    sys.exit(main())
