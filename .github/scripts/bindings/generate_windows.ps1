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

# Windows SDK providing the headers of WGL : the one of the committed bindings if installed,
# the latest otherwise
$sdks = Get-ChildItem "${env:ProgramFiles(x86)}\Windows Kits\10\Include" -Directory `
  | Where-Object { Test-Path "$($_.FullName)\um\windows.h" } `
  | Sort-Object { [version]$_.Name }
"Windows SDK installed : $($sdks.Name -join ', ')"
$sdk = $sdks | Where-Object { $_.Name -eq '10.0.19041.0' } | Select-Object -First 1
if (-not $sdk) { $sdk = $sdks | Select-Object -Last 1 }
"Windows SDK $($sdk.Name)" | Tee-Object -FilePath "$Out\versions.txt" -Append

function Run([string]$Package, [string[]]$Arguments) {
  & $JExtract @Arguments --dump-includes "$Out\$Package.includes" *> "$Out\$Package.log"
  if ($LASTEXITCODE -eq 0) { & $JExtract @Arguments *>> "$Out\$Package.log" }
  return $LASTEXITCODE -eq 0
}

# jextract may fail on the anonymous structs and unions of the SDK headers (TypeLayoutError :
# InvalidFieldName). They are then named (DUMMYSTRUCTNAME, DUMMYUNIONNAME...) by defining
# NONAMELESSUNION, and the COM and OLE headers, which PanamaGL does not use, are excluded by
# defining WIN32_LEAN_AND_MEAN
$fallbacks = @(
  @(),
  @('-D', 'NONAMELESSUNION'),
  @('-D', 'NONAMELESSUNION', '-D', 'WIN32_LEAN_AND_MEAN')
)

function Generate([string]$Package, [string]$HeaderClass, [string]$Header, [string[]]$Options) {
  $common = @('--target-package', $Package, '--header-class-name', $HeaderClass, '--output', $Out) + $Options
  foreach ($defines in $fallbacks) {
    Remove-Item -Recurse -Force -ErrorAction SilentlyContinue "$Out\$($Package.Replace('.', '\'))"
    if (Run $Package ($common + $defines + $Header)) {
      "$Package generated with defines : $($defines -join ' ')" | Tee-Object -FilePath "$Out\versions.txt" -Append
      return
    }
    Get-Content "$Out\$Package.log" | Where-Object { $_ -notmatch 'warning' } | Select-Object -Last 5
  }
  throw "jextract failed for $Package"
}

Push-Location $Scripts
try {
  Generate 'wgl.windows' 'wgl_h' 'include_wgl.h' @('-I', "$($sdk.FullName)\um", '-I', "$($sdk.FullName)\shared")
  Generate 'freeglut.windows' 'freeglut_h' 'GL/freeglut.h' @('-I', '.')
} finally {
  Pop-Location
}
