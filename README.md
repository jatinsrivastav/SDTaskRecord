
# Record API (Spring Boot)

## Overview

This is a RESTful API built using Spring Boot that supports CRUD operations with filtering, basic API key authentication, and Swagger documentation.

---

## Features

* Add, update, delete, and retrieve records
* Filter records by status or category
* API key-based authentication
* Global exception handling
* Swagger UI for API documentation

---

## Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* H2 Database
* Swagger (Springdoc OpenAPI)

---

## Running Locally

### Prerequisites

* Java 17+
* Maven

### Steps

```bash
mvn clean install
mvn spring-boot:run
```

Application will start at:


http://localhost:8080
```

---

## API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```



## Authentication

All APIs require an API key in header:


x-api-key: my-secret-key

## Sample API

### Get all records

```
GET /records
```

---

## Deployment

Application is deployed at:


```
