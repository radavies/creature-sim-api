# Creature Sim API
Java Dropwizard API for Creature Sim Project.

## Setup / Running Locally
### Setup
* Install Java 11 JDK.
* Install Gradle
* Build the project project

### Running Locally
* Main class should be: `creaturesim.CreatureSimApplication`
* Program arguments are: server dev.yml (where the yml file is for the environment you are running)
* Class path should be: `creaturesimapi.main`
* JRE 11
* To use a Dynamo table in AWS (not local) you need to set the env variables AWS_ACCESS_KEY_ID & AWS_SECRET_ACCESS_KEY
    * You can use the command line to `export` or set them in IntelliJ's configs

You should be able to use the above setting to run/debug in your IDE or via the command line.

#### DynamoDB Local

You can use [dynamodb-local](https://hub.docker.com/r/amazon/dynamodb-local/) docker image to run the data store locally.

To run the DB in shared mode (where the same data will be available to the app and workbench) use:

`docker run -d -p 8000:8000 -v $(pwd)/local/dynamodb:/data/ amazon/dynamodb-local -jar DynamoDBLocal.jar -sharedDb -dbPath /data`

If you create a table (for example via workbench) you can check it has been added to the local DB by running:

`aws dynamodb list-tables --endpoint-url http://localhost:8000`

Delete tables using:

`aws dynamodb delete-table --table-name TABLENAME --endpoint-url http://localhost:8000`

Some useful links for using the Dynamo client in AWS SDK V2:
* [Creating clients](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/creating-clients.html)
* [Working with tables](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/examples-dynamodb-tables.html)
* [github examples](https://github.com/awsdocs/aws-doc-sdk-examples)