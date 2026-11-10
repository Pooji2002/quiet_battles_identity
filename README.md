# QUIET BATTLES™ – Identity Service

The Identity Service is a backend microservice responsible for user authentication, registration, and authorization in the QUIET BATTLES™ application.

It provides secure authentication using JSON Web Tokens (JWT) and supports role-based access for customers and administrators.

## Technology Stack

- Java 17
- Spring Boot 4.1.2
- Spring Security
- Spring Data JPA
- MySQL
- JSON Web Token (JWT)
- JJWT 0.12.6
- Maven
- Spring Boot Actuator
- Bean Validation

## Service Overview

| Property | Value |
|---|---|
| Service Name | Identity Service |
| Port | 8091 |
| Database | qb_identity_db |
| Build Tool | Maven |
| Authentication | JWT |
| Authorization | Role-based access |

## Key Features

### 1. User Registration
- Allows new customers to register.
- Accepts user details through REST APIs.
- Validates incoming request data.
- Stores user information in the Identity database.

### 2. User Login
- Authenticates users using their login credentials.
- Verifies credentials through Spring Security.
- Generates a JWT after successful authentication.
- Returns authentication details to the frontend.

### 3. JWT Authentication
- Generates JWT tokens for authenticated users.
- Supports token-based authentication for protected requests.
- Allows other backend services to validate authenticated requests through the application's security configuration.

### 4. Role-Based Authorization

The application supports the following roles:

- **USER** – Customer access.
- **ADMIN** – Administrative access.

Role-based authorization helps restrict administrative functionality to authorized users.

## Microservice Architecture

The Identity Service operates independently and communicates with the frontend through the API Gateway.

**Application flow:**

Frontend → API Gateway (8090) → Identity Service (8091) → MySQL

The API Gateway forwards authentication requests to this service.

## Database Configuration

The service uses MySQL with the database:

`qb_identity_db`

Create the database before starting the application:

```sql
CREATE DATABASE qb_identity_db;
```

Configure the database connection and JWT settings in the application's configuration file.

**Security note:** Database passwords and JWT signing secrets should be supplied through environment variables or secure configuration. Do not commit real credentials or signing keys to GitHub.

## Running the Application Locally

### Prerequisites

- Java 17 or later
- Maven
- MySQL Server
- Git

### 1. Clone the repository

```bash
git clone https://github.com/Pooji2002/quiet_battles_identity.git
```

### 2. Open the project

Open the cloned project in Eclipse, IntelliJ IDEA, or VS Code.

### 3. Configure MySQL

Create the `qb_identity_db` database and configure the database connection.

### 4. Run the service

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class from your IDE.

The service runs on:

`http://localhost:8091`

## Integration with Other Services

The Identity Service is integrated with the QUIET BATTLES™ API Gateway.

| Component | Port |
|---|---:|
| API Gateway | 8090 |
| Identity Service | 8091 |
| Content Service | 8092 |
| Product Service | 8093 |
| Order Service | 8094 |

The frontend communicates with authentication APIs through the Gateway rather than directly accessing the Identity Service.

## Project Repository

GitHub: https://github.com/Pooji2002/quiet_battles_identity

## Project Context

This service is part of the QUIET BATTLES™ full-stack application, developed as a microservices-based fashion and lifestyle e-commerce prototype.

**Brand Tagline: WEAR YOUR BATTLES.**