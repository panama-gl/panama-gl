DEMOS 
- see test folder

# Troubleshooting

Exception in thread "main" java.lang.UnsatisfiedLinkError: Could not load SWT library. Reasons: 
	no swt-cocoa-4965r11 in java.library.path: /Users/martin/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.
	no swt-cocoa in java.library.path: /Users/martin/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.
	no swt in java.library.path: /Users/martin/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.
	Can't load library: /Users/martin/.swt/lib/macosx/aarch64/libswt-cocoa-4965r11.jnilib
	Can't load library: /Users/martin/.swt/lib/macosx/aarch64/libswt-cocoa.jnilib
	Can't load library: /Users/martin/.swt/lib/macosx/aarch64/libswt.jnilib
	/Users/martin/.swt/lib/macosx/aarch64/libswt-cocoa-4965r11.jnilib: dlopen(/Users/martin/.swt/lib/macosx/aarch64/libswt-cocoa-4965r11.jnilib, 0x0001): tried: '/Users/martin/.swt/lib/macosx/aarch64/libswt-cocoa-4965r11.jnilib' (mach-o file, but is an incompatible architecture (have 'x86_64', need 'arm64e' or 'arm64')), '/System/Volumes/Preboot/Cryptexes/OS/Users/martin/.swt/lib/macosx/aarch64/libswt-cocoa-4965r11.jnilib' (no such file), '/Users/martin/.swt/lib/macosx/aarch64/libswt-cocoa-4965r11.jnilib' (mach-o file, but is an incompatible architecture (have 'x86_64', need 'arm64e' or 'arm64'))


May be due to launcher not running on appropriate architecture 
- CLI JDK
- MVN JDK
- IDE JDK

## Commencer par clean le cache
rm -rf ~/.swt

Pour forcer Eclipse à utiliser Java en mode ARM64, voici les solutions :

## Solution 1 : Modifier eclipse.ini (Recommandé)

Édite le fichier `eclipse.ini` (clic droit sur Eclipse.app → "Afficher le contenu du paquet" → Contents/Eclipse/eclipse.ini) :

```ini
-startup
plugins/org.eclipse.equinox.launcher_1.x.x.jar
--launcher.library
plugins/org.eclipse.equinox.launcher.cocoa.macosx.aarch64_1.x.x.so
-vm
/Library/Java/JavaVirtualMachines/openjdk-21.jdk/Contents/Home/bin/java
-vmargs
-Dosgi.requiredJavaVersion=17
-Xms256m
-Xmx2048m
```

**Important :** La ligne `-vm` doit pointer vers un JDK ARM64 pur et doit être **avant** `-vmargs`.

Pour trouver le chemin exact :

```bash
/usr/libexec/java_home -v 21
# Copie le résultat et ajoute /bin/java
```

## Solution 2 : Configurer le JRE dans Eclipse

1. **Eclipse → Preferences → Java → Installed JREs**
2. Clique sur **Add...**
3. Sélectionne **Standard VM** → **Next**
4. **JRE home** : Utilise `/usr/libexec/java_home -v 21` pour trouver le chemin
5. Coche cette nouvelle JRE comme **default**

Ensuite, pour ton projet :

1. **Clic droit sur ton projet → Properties**
2. **Java Build Path → Libraries**
3. **Double-clic sur JRE System Library**
4. Sélectionne **Workspace default JRE** ou la JRE ARM64 que tu viens d'ajouter

## Solution 3 : Configuration de lancement (Run Configuration)

1. **Run → Run Configurations...**
2. Sélectionne ta configuration Java Application
3. Onglet **JRE**
4. Sélectionne **Alternate JRE** et choisis un JDK ARM64

Dans l'onglet **Arguments**, ajoute aussi :

```
VM arguments:
-XstartOnFirstThread
```

(Nécessaire pour SWT sur macOS)

## Solution 4 : Installer un Eclipse ARM64 natif

Si ton Eclipse lui-même tourne en x86_64, ça peut causer des problèmes :

```bash
# Vérifier l'architecture d'Eclipse
file /Applications/Eclipse.app/Contents/MacOS/eclipse

# Télécharger Eclipse ARM64 pour macOS
# https://www.eclipse.org/downloads/
# Choisis "macOS AArch64" (Apple Silicon)
```

## Vérification finale dans Eclipse

Crée un petit programme de test :

```java
public class CheckArch {
    public static void main(String[] args) {
        System.out.println("os.arch: " + System.getProperty("os.arch"));
        System.out.println("java.version: " + System.getProperty("java.version"));
        System.out.println("java.home: " + System.getProperty("java.home"));
    }
}
```

Lance-le et vérifie que `os.arch = aarch64`.

## Pour ton projet SWT spécifique

Après avoir configuré le JDK ARM64 :

```bash
# Supprimer le cache SWT
rm -rf ~/.swt

# Dans Eclipse :
# Project → Clean...
# Project → Build Project
```

Ensuite lance ton `DemoSWTThorus` depuis Eclipse.

Quelle solution veux-tu essayer en premier ? Je te recommande la **Solution 1** (modifier eclipse.ini) car c'est la plus fiable.