# 📦 BE_Spring_Boot (Spring Boot Project)

A [Spring Boot](https://spring.io/projects/spring-boot) project built with Java 21, PostgreSQL, and Docker. This project provides a backend API for managing sales and products, with validation and stock management logic.

---

## 🚀 Features

- Built with **Spring Boot 3.5.3**
- RESTful APIs using **Spring Web**
- **PostgreSQL** database
- **Spring Data JPA** for ORM
- **OpenAPI/Swagger UI** for API documentation
- **Docker Compose** for PostgreSQL + pgAdmin setup
- **DevTools** enabled for hot-reloading

---

## 🛠️ Tech Stack

| Technology       | Version     |
|------------------|-------------|
| Java             | 21          |
| Spring Boot      | 3.5.3       |
| PostgreSQL       | 15          |
| OpenAPI (Springdoc) | 2.5.0   |
| pgAdmin          | Latest      |

---

## 📂 Project Structure
    practice-BE/
    ├── src/
    ├── docker-compose.yaml
    ├── pom.xml
    └── README.md


---

## 🐳 Docker Setup

### 1. Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/)

### 2. Run Docker Containers

```bash
docker-compose up -d
```
### 3. Launch

PostgreSQL at localhost:5432

pgAdmin at http://127.0.0.1:5050/

## pgAdmin login
- Email: admin@admin.com
- Password: admin

---
# 🧪 Run the Application
### 1. Clone the project
```bash
git clone https://github.com/tonkla785/BE_Spring_Boot.git
```
### 2.Set up your  ```application.properties```
```
#Example

spring.application.name=practice-BE

spring.datasource.url=jdbc:postgresql://localhost:5432/practicedb
spring.datasource.username=admin
spring.datasource.password=admin123
spring.sql.init.mode=always
```
### 3. Run the backend (from IDE or CLI)
```
./mvnw spring-boot:run
```

---

# 📘 API Documentation
Once the app is running visit:

- http://localhost:8080/swagger-ui/index.html

You will see Swagger UI with all available endpoints.

---
# Developer
Name: Phichitpon

University: Kmutnb

Contact: tonkla785@gmail.com

---
