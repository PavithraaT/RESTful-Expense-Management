RESTful Expense Management Backend System
-----------------------------------------

Project Overview:-
This project is a backend system to manage financial expenses using Java and Spring Boot. It exposes RESTful APIs for performing CRUD operations (Create, Read, Update, Delete) on expenses. The project is designed for maintainability, clarity, and scalability, making it easy to extend in the future.

Key Highlights:-
-Developed with Java, Spring Boot, and Maven.
-RESTful API design using standard HTTP methods.
-DTO pattern used for safe data transfer between layers.
-Global exception handling for consistent error responses.
-Validated API requests to prevent incorrect data.
-Tested APIs using Postman, covering normal and edge cases.

Technologies Used:-
Language: Java 17
Framework: Spring Boot
Database: H2 (in-memory; simulates SQLite for development)
Build Tool: Maven
Testing: JUnit, Postman
Other Concepts: DTOs, Exception Handling, Service Layer Architecture


Project Structure:-

expense-management-backend/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/demo/
│       │       ├── config/                  # Application configuration
│       │       │   └── WebConfig.java
│       │       │
│       │       ├── controller/              # REST controllers (handles HTTP requests)
│       │       │   └── ExpenseController.java
│       │       │
│       │       ├── dto/                     # Data Transfer Objects (safe API layer)
│       │       │   └── ExpenseDTO.java
│       │       │
│       │       ├── exception/               # Custom exceptions & global handlers
│       │       │   ├── ResourceNotFoundException.java
│       │       │   └── GlobalExceptionHandler.java
│       │       │
│       │       ├── model/                   # Entity classes (database layer)
│       │       │   └── Expense.java
│       │       │
│       │       ├── repository/              # Data access layer (JPA repositories)
│       │       │   └── ExpenseRepository.java
│       │       │
│       │       └── service/                 # Business logic layer
│       │           ├── ExpenseService.java
│       │           └── ExpenseServiceImpl.java
│       │
│       └── resources/
│           └── application.properties       # Spring Boot & DB configs
│
├── test/
│   └── java/com/example/demo/
│       └── DemoApplicationTests.java       # Unit & integration tests
│
├── .gitignore                               # Ignore target, IDE files, etc.
├── mvnw / mvnw.cmd                           # Maven wrapper
├── pom.xml                                  # Maven dependencies
└── README.md                                # Project description & instructions


Database:-
-H2 in-memory database for fast setup and testing.
-The schema is auto-generated using JPA/Hibernate.


Entity: Expense
id (Long, primary key)
title (String)
amount (Double)
description (String)
date (LocalDateTime)


API Endpoints:-

| Method | Endpoint       | Request Body / Params | Description                |
| ------ | -------------- | --------------------- | -------------------------- |
| GET    | /expenses      | None                  | Get all expenses           |
| GET    | /expenses/{id} | id (path variable)    | Get expense by ID          |
| POST   | /expenses      | ExpenseDTO JSON       | Create a new expense       |
| PUT    | /expenses/{id} | id + ExpenseDTO       | Update an existing expense |
| DELETE | /expenses/{id} | id (path variable)    | Delete an expense          |



Example JSON for POST/PUT:-

{
  "title": "Groceries",
  "amount": 250.0,
  "description": "Weekly grocery shopping",
  "date": "2026-04-05T10:00:00"
}


Exception Handling:-
-ResourceNotFoundException: Thrown when expense with given ID does not exist.
-GlobalExceptionHandler: Handles exceptions globally and returns standardized HTTP responses.

Example Response (Resource Not Found):

{
  "timestamp": "2026-04-05T10:05:00",
  "message": "Expense with id 101 not found",
  "details": "uri=/expenses/101"
}


Service Layer:-
ExpenseService- interface defines business methods.
ExpenseServiceImpl- implements these methods.
ExpenseRepository- handles all database operations using Spring Data JPA.


Validation:-
-Ensures title, amount, date are valid.
-Prevents null or invalid data from entering the database.

-------------------------------------------------------------------

How to Run:-

1.Clone the repository:
git clone <your-repo-link>

2.Open project in IntelliJ IDEA or Eclipse as a Maven project.

3.Run the main class: DemoApplication.java

4.Access H2 console:
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

5.Test APIs using Postman.
---------------------------------------------------------------------

Testing:-
-CRUD operations tested with normal and edge cases:
-Non-existent ID → returns proper exception.
-Missing fields → validation error.
-Response structure verified for all endpoints.

