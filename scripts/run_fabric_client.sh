#!/bin/bash

echo "Current path is $PWD"

echo "Launching Fabric version"

./gradlew fabric:build

# Load variables
if [ -f ./env.sh ]; then
  source ./env.sh
else
  echo "File env.sh not found. Create it using template env.template.sh"
  exit 1
fi

JAR_PATH=$(find ./../fabric/build/libs/ -name '*.jar' | grep -vE '(-dev-shadow|-sources)\.jar$' | tr '\n' ' ')
echo "$JAR_PATH"
cp $JAR_PATH $MOD_DEST_PATH_FABRIC

$MULTIMC_PATH --launch $INSTANCE_NAME_FABRIC

echo "Finished"
