#!/bin/bash
cd "$(dirname "$0")"

# Compiler
echo "Compilation..."
mvn compile

# Construire le classpath complet avec toutes les dépendances Maven
echo "Construction du classpath..."
mvn dependency:build-classpath -Dmdep.outputFile=cp.txt -q

# Lire le classpath et ajouter target/classes
CP="target/classes:$(cat cp.txt)"

echo "Classpath: $CP"
echo ""
echo "Lancement de la démo..."

# Lancer
java -XstartOnFirstThread \
  --enable-native-access=ALL-UNNAMED \
  -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/ \
  -cp "$CP" \
  demos.panamagl.swt.DemoSWTThorus

# Nettoyer
rm cp.txt