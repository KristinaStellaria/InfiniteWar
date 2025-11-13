#!/bin/bash

echo "Current path is $PWD"

echo "Launching Forge version"

./gradlew forge:build

# Load variables
if [ -f ./env.sh ]; then
  source ./env.sh
else
  echo "File env.sh not found. Create it using template env.template.sh"
  exit 1
fi

JAR_PATH=$(find ./../forge/build/libs/ -name '*.jar' | grep -vE '(-dev-shadow|-sources)\.jar$' | tr '\n' ' ')
echo "$JAR_PATH"
cp $JAR_PATH $MOD_DEST_PATH_FORGE

$MULTIMC_PATH --launch $INSTANCE_NAME_FORGE

echo "Finished"
