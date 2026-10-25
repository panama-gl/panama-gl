# Generate the Windows binding of PanamaGL with jextract, as
# panama-gl-bindings/scripts/windows/generate_opengl.bat does, so that the
# bindings generated on x64 and ARM64 can be compared.
#
# Usage : generate_windows.ps1 <jextract.bat> <panama-gl-bindings/scripts/windows> <output dir>
param([string]$JExtract, [string]$Scripts, [string]$Out)
$ErrorActionPreference = 'Stop'

New-Item -ItemType Directory -Force -Path $Out | Out-Null
$Out = (Resolve-Path $Out).Path
$Scripts = (Resolve-Path $Scripts).Path
$JExtract = (Resolve-Path $JExtract).Path

# Windows SDK providing the headers of WGL : the one of the committed bindings if installed,
# the latest otherwise (the same on both CPUs)
$sdks = Get-ChildItem "${env:ProgramFiles(x86)}\Windows Kits\10\Include" -Directory `
  | Where-Object { Test-Path "$($_.FullName)\um\windows.h" } `
  | Sort-Object { [version]$_.Name }
"Windows SDK installed : $($sdks.Name -join ', ')"
$sdk = $sdks | Where-Object { $_.Name -eq '10.0.19041.0' } | Select-Object -First 1
if (-not $sdk) { $sdk = $sdks | Select-Object -Last 1 }
"Windows SDK $($sdk.Name)" | Tee-Object -FilePath "$Out\versions.txt" -Append

# The single filtered binding of panama-gl-bindings/scripts/windows/generate_opengl.py
Push-Location $Scripts
try {
  # Into a sub folder, which generate_opengl.py empties
  python generate_opengl.py $JExtract $sdk.FullName "$Out\java" *> "$Out\opengl.windows.log"
  if ($LASTEXITCODE -ne 0) {
    Get-Content "$Out\opengl.windows.log" | Where-Object { $_ -notmatch 'warning' } | Select-Object -Last 30
    throw "jextract failed for opengl.windows"
  }
  Move-Item -Force windows.includes "$Out\opengl.windows.includes"
  Remove-Item all.includes
} finally {
  Pop-Location
}
