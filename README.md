# 📋 Task Manager API

A REST API developed in Java with Spring Boot during the Santander Bootcamp in partnership with DIO (Digital Innovation One).

This project implements a simple task management system following software engineering best practices, including layered architecture, separation of concerns, and Clean Architecture principles.

---

## 🚀 Technologies

- Java 21
- Spring Boot 4
- Spring Web
- Spring Validation
- Gradle
- Lombok
- REST API

---

## 🏗️ Architecture

The project is organized into layers to improve maintainability, scalability, and testability.

```
src
├── application
│   ├── input
│   ├── output
│   └── usecases
├── domain
├── infrastructure
│   ├── http
│   └── repository
└── resources
```

### Layers

- **Domain**
  - Contains the business rules.
  - Entities, enums, interfaces, and custom exceptions.

- **Application**
  - Contains the application's use cases.
  - Input and output DTOs.

- **Infrastructure**
  - REST controllers.
  - In-memory repository.
  - Global exception handling.

---

## ⭐ Features

- ✅ Create a task
- ✅ Retrieve a task by ID
- ✅ List all tasks
- ✅ Update a task
- ✅ Delete a task

---

## 📖 Task Model

```json
{
  "id": "UUID",
  "title": "Study Spring Boot",
  "description": "Complete the REST API module",
  "status": "PENDING"
}
```

### Available Status

- `PENDING`
- `IN_PROGRESS`
- `COMPLETED`

---

## 🌐 API Endpoints

### Create Task

```http
POST /tasks
```

### List Tasks

```http
GET /tasks
```

### Get Task by ID

```http
GET /tasks/{id}
```

### Update Task

```http
PATCH /tasks/{id}
```

### Delete Task

```http
DELETE /tasks/{id}
```

---

## ▶️ Running the Project

### Prerequisites

- Java 21
- Gradle

Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/task-manager-api.git
```

Navigate to the project folder:

```bash
cd task-manager-api
```

Run the application:

```bash
./gradlew bootRun
```

On Windows:

```cmd
gradlew.bat bootRun
```

The application will be available at:

```
http://localhost:8080
```

---

## 💡 Skills Demonstrated

- REST API Development
- Spring Boot
- Java 21
- Clean Architecture
- CRUD Operations
- Dependency Injection
- DTO Pattern
- Exception Handling
- Layered Architecture
- Repository Pattern
- Validation

---

## 📚 What I Learned

This project allowed me to strengthen my knowledge of:

- Designing RESTful APIs with Spring Boot.
- Applying Clean Architecture principles.
- Separating business logic from infrastructure concerns.
- Implementing CRUD operations.
- Using DTOs for data transfer.
- Organizing Java applications with a scalable layered architecture.
- Following software development best practices.

---

## 👨‍💻 Author

**Daniel Henrique Bartholdy**

- LinkedIn: https://www.linkedin.com/in/daniel-bartholdy/

---

## 🎓 Acknowledgements

This project was developed during the **Santander Bootcamp**, offered in partnership with **Digital Innovation One (DIO)**, as part of my backend development studies using Java and Spring Boot.
