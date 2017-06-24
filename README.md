# Reladomo-scala

Example for using reladomo in scala

## Modules
### reladomo-gen
code to generate reladomo classes

### reladomo-sample
demonstrate usage of reladomo classes

## Run
1. Generate reladomo code by running `reladomo.example.MithraGeneratorExample`
This will read reladomo ddl in `resources/reladomo/models` and generate java classes in:
  * reladomo-sample/target/java
  * reladomo-sample/src/main/java
  
2. Now you can run code example in `reladomo-sample`
  * example.HelloReladomoApp
  * reladomo.example.PersonTest