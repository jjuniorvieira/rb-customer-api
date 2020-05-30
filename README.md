# REST API to the Customer Application 

This is the Rest API to the Customer Applocation implemented to prove my knowledge in some of the technologies and frameworks back-end

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Pre requirements
```
- Java 11
- Mvn
```

## Install
```
mvn clean install
```

## Run the app
```
mvn spring-boot:run
```

## Run the tests
```
mvn test
```

# REST API

The REST API documentation to the Customer Application could be found the Swagger UI link below. Note that you can test the REST API through Swagger UI.

http://localhost:8080/swagger-ui.html

## Documentation in Json Format

http://localhost:8080/v2/api-docs

## In memory database access

http://localhost:8080/h2-console/


# Features

## Requirement 
Developer Assignment

Engineers at customer management have asked you to develop a service for them that allows
them to read, save, and edit customer data.
Your service should be accessible via a REST API.
Act as if this code is meant to be production code.
The engineers at customer management want to be able to easily run your service on their own
machines (for testing purposes), including database(s).
Below are the specifications for the Customer model:

- Customer
- First name (unique in combination with last name)
- Last name
- Age
- Date of Birth
- Current address

For now, only the following endpoints are required:
- Create Customer
- Get Customer
- Update Customer Address

## Technologies/Frameworks 
- Spring-boot 2.3.0
- Spring Data
- H2 Database
- JPA
- Swagger
- Swagger UI
- Docker
- Jacoco


# Future features
- Spring Security
- Spring AOP
- Mult-module project (TBD with PO)
- Heroku profile 
- UI module project (TBD with PO)
