#!/bin/bash

# 전체 경로 처리
FILE_PATH="$(realpath "$1")"
DIR_PATH="$(dirname "$FILE_PATH")"
BASENAME="$(basename "$FILE_PATH" .kt)"
JAR_NAME="$DIR_PATH/$BASENAME.jar"

kotlinc "$FILE_PATH" -include-runtime -d "$JAR_NAME" && \
java -jar "$JAR_NAME" && \
rm "$JAR_NAME"
