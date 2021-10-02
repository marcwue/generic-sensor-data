# generic-sensor-data-collector

## Usage

### Run the application locally

`lein ring server`

### Packaging and running as standalone jar

```
lein do clean, ring uberjar
java -jar target/server.jar
```
## Container

TODO DOCKERFILE

## Architecture

### compojure-api

#### clojure.spec.alpha with spec-tools.spec (for swagger)

### lein ring plugin

### monger for mongodb
