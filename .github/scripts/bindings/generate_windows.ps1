# Generate the Windows bindings of PanamaGL with jextract, as the scripts of
# panama-gl-bindings/scripts/windows do, but in packages without CPU name so
# that the bindings generated on x64 and ARM64 can be compared.
#
# Usage : generate_windows.ps1 <jextract.bat> <panama-gl-bindings/scripts/windows> <output dir>
param([string]$JExtract, [string]$Scripts, [string]$Out)
$ErrorActionPreference = 'Stop'

New-Item -ItemType Directory -Force -Path $Out | Out-Null
$Out = (Resolve-Path $Out).Path
$Scripts = (Resolve-Path $Scripts).Path
$JExtract = (Resolve-Path $JExtract).Path

# Latest Windows SDK providing the headers of WGL
$sdk = Get-ChildItem "${env:ProgramFiles(x86)}\Windows Kits\10\Include" -Directory `
  | Where-Object { Test-Path "$($_.FullName)\um\windows.h" } `
  | Sort-Object { [version]$_.Name } | Select-Object -Last 1
"Windows SDK $($sdk.Name)" | Tee-Object -FilePath "$Out\versions.txt" -Append

function Generate([string]$Package, [string]$HeaderClass, [string]$Header, [string[]]$Options) {
  $common = @('--target-package', $Package, '--header-class-name', $HeaderClass, '--output', $Out) + $Options
  & $JExtract @common --dump-includes "$Out\$Package.includes" $Header *> "$Out\$Package.log"
  & $JExtract @common $Header *>> "$Out\$Package.log"
  if ($LASTEXITCODE -ne 0) { Get-Content "$Out\$Package.log" | Select-Object -Last 30; throw "jextract failed for $Package" }
}

Push-Location $Scripts
try {
  Generate 'wgl.windows' 'wgl_h' 'include_wgl.h' @('-I', "$($sdk.FullName)\um", '-I', "$($sdk.FullName)\shared")
  Generate 'freeglut.windows' 'freeglut_h' 'GL/freeglut.h' @('-I', '.')
} finally {
  Pop-Location
}
