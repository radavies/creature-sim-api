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

You should be able to use the above setting to run/debug in your IDE or via the command line.

#### DynamoDB Local

You can use [dynamodb-local](https://hub.docker.com/r/amazon/dynamodb-local/) docker image to run the data store locally.

To run the DB in shared mode (where the same data will be available to the app and workbench) use:

`docker run -p 8000:8000 -v $(pwd)/local/dynamodb:/data/ amazon/dynamodb-local -jar DynamoDBLocal.jar -sharedDb -dbPath /data`