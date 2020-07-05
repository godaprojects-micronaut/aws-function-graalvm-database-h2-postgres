#!/bin/bash
docker build . -t aws-function-graalvm-database-h2-postgres
mkdir -p build
docker run --rm --entrypoint cat aws-function-graalvm-database-h2-postgres  /home/application/function.zip > build/function.zip
