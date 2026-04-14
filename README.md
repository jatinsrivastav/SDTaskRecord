# Record Management API

## Overview

This is a RESTful API built using Spring Boot that supports CRUD operations on records.
It includes filtering, API key-based authentication, global exception handling, and Swagger documentation.

---

##  Live Application

Base URL:

```
https://sdtaskrecord-1.onrender.com
```

Swagger UI:

```
https://sdtaskrecord-1.onrender.com/swagger-ui/index.html
```

🔐 Authorization (Important)

All APIs are secured using an API key.
Before testing endpoints in Swagger, you must authorize:

Steps:
* Open Swagger UI
* Click on the "Authorize" button (top-right corner)
* Enter the API key:

my-secret-key

* Click Authorize → then Close
* Now you can execute API requests successfully


##  Features

* Create, update, delete, and retrieve records
* Filter records by status or category
* API key-based authentication
* Global exception handling
* Input validation
* Swagger UI for API documentation

---

##  Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* H2 Database
* Maven
* Swagger (Springdoc OpenAPI)

---

##  Running Locally

### Prerequisites

* Java 17 or higher
* Maven installed

### Steps to Run

```
mvn clean install
mvn spring-boot:run
```

Application will start at:

```
http://localhost:8080
```

---

## Authentication

All APIs are secured using an API key.

Add this header in every request:

```
x-api-key: my-secret-key
```

---

##  API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

For deployed version:

```
https://sdtaskrecord-1.onrender.com/swagger-ui/index.html
```

Use the **Authorize** button in Swagger to enter the API key.

---

##  API Endpoints

| Method | Endpoint      | Description                             |
| ------ | ------------- | --------------------------------------- |
| GET    | /records      | Get all records (with optional filters) |
| POST   | /records      | Create a new record                     |
| PUT    | /records/{id} | Update a record                         |
| DELETE | /records/{id} | Delete a record                         |

---

##  Sample Request

### Create Record

```
POST /records
```

```json
{
  "name": "Test",
  "category": "General",
  "status": "ACTIVE"
}
```

---

## Project Structure

```
controller/
service/
repository/
entity/
dto/
exception/
config/
```

---

