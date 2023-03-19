#!/bin/bash

# Change directory to the folder containing the Spring Boot projects
cd base-domains
 # Execute the project using Maven
mvn spring-boot:run &
 # Change directory back to the parent directory
cd ..
cd order-service
 # Execute the project using Maven
mvn spring-boot:run &
 # Change directory back to the parent directory
cd ..
cd transaction-service
 # Execute the project using Maven
mvn spring-boot:run &
 # Change directory back to the parent directory
cd ..
cd inventory-service
 # Execute the project using Maven
mvn spring-boot:run &
 # Change directory back to the parent directory
cd ..
