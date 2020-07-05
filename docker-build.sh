#!/bin/sh
docker build . -t aws-function-graalvm-database-h2-postgres
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 aws-function-graalvm-database-h2-postgres"
