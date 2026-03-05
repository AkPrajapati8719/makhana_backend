# 🌿 Evendri Backend API (Spring Boot)

Welcome to the backend of **Evendri**, a premium Direct-to-Consumer (D2C) E-commerce platform for organic Makhana. This repository powers the RESTful API for the frontend, handling business logic, data persistence, and secure transactions.

---

## 📦 Architecture Overview

- **Layered Structure:**
  - Controller: Handles HTTP requests and API endpoints.
  - Service: Encapsulates business logic and validation.
  - Repository: Manages data access via Spring Data JPA.
  - Model: Entity classes for domain objects (User, Product, Order, Cart).
- **Security:**
  - Configurable authentication and authorization (Spring Security).
  - CORS enabled for frontend integration.
- **Database:**
  - Default: PostgreSQL (see `application.properties`).
  - Sample data in `data.sql` for local testing.

---

## ⚙️ Technology Stack

- **Language:** Java 21
- **Framework:** Spring Boot 4.x
- **Database:** PostgreSQL (default), MySQL supported
- **ORM:** Spring Data JPA / Hibernate
- **Build Tool:** Maven

---

## ✨ Features

- **User Management:** Registration, login, profile, roles (admin/user)
- **Product Catalog:** CRUD for Makhana products, image upload
- **Order Processing:** Create, view, and manage orders; order status tracking
- **Cart Sync:** Save and sync user cart data
- **Payment Integration:** Razorpay-ready endpoints for secure payments
- **Data Initialization:** Auto-load sample data for quick setup

---

## 🚀 Getting Started

### 1. Prerequisites

- Java 21+
- Maven 3.8+
- PostgreSQL (default) or MySQL

### 2. Database Setup

- **PostgreSQL:**
  - Create a database:
    ```sql
    CREATE DATABASE makhana_database;
    ```
  - Update credentials in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.username=postgres
    spring.datasource.password=YOUR_PASSWORD
    ```
- **MySQL:**
  - Update JDBC URL and credentials in `application.properties` as needed.

### 3. Build & Run

- Open the project in your IDE (IntelliJ, Eclipse, VS Code) or terminal.
- Install dependencies:
  ```bash
  mvn clean install
  ```
- Start the server:
  ```bash
  mvn spring-boot:run
  ```
- The API will be available at [http://localhost:8082](http://localhost:8082)

---

## 🛠️ API Endpoints Overview

| Resource | Endpoint                    | Method | Description                 |
| -------- | --------------------------- | ------ | --------------------------- |
| User     | `/api/users/register`       | POST   | Register new user           |
| User     | `/api/users/login`          | POST   | User login                  |
| Product  | `/api/products`             | GET    | List all products           |
| Product  | `/api/products/add`         | POST   | Add new product             |
| Order    | `/api/orders/create`        | POST   | Create new order            |
| Order    | `/api/orders/user/{userId}` | GET    | Get user order history      |
| Order    | `/api/orders/all`           | GET    | Get all orders (admin)      |
| Cart     | `/api/cart/sync/{userId}`   | POST   | Sync cart data              |
| Payment  | `/api/payment/create-order` | POST   | Initiate payment (Razorpay) |

---

## 🧪 Testing & Sample Data

- Sample products and users are auto-loaded from `data.sql` on startup.
- Use tools like Postman or curl to interact with the API.

---

## 📝 Contribution Guidelines

1. Fork the repository and create a feature branch.
2. Follow Java and Spring Boot best practices.
3. Write clear commit messages and document your code.
4. Submit a pull request with a detailed description.

---

## 📚 References & Documentation

- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Data JPA Guide](https://spring.io/projects/spring-data-jpa)
- [Spring Security Docs](https://spring.io/projects/spring-security)
- [Maven Documentation](https://maven.apache.org/guides/index.html)

---

## 💡 Notes

- Keep the backend server running before starting the React frontend to ensure API connectivity.
- For production, update environment variables and security settings as needed.

---


