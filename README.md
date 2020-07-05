# WORK IN PROGRESS

# AWS Function with Database
A AWS lambda function which works with databases like H2 and PostgreSQL

1. Create the app
```
mn create-app aws-function-graalvm-database-h2-postgres --build maven --features graalvm,aws-lambda-custom-runtime
``` 
2. AWS Function that integrates with database. Does not work. Have to check further. But the depedencyh injection works. Something wrong with entitymanager.


## Feature aws-lambda-custom-runtime documentation

- [Micronaut Custom AWS Lambda runtime documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#lambdaCustomRuntimes)

- [https://docs.aws.amazon.com/lambda/latest/dg/runtimes-custom.html](https://docs.aws.amazon.com/lambda/latest/dg/runtimes-custom.html)

## Feature aws-lambda documentation

- [Micronaut AWS Lambda Function documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#lambda)

