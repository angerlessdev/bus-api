# Bus API

API for managing buses and bus brands, following DDD (Domain-Driven Design) and Clean Architecture.  
Allows creating, querying, and paginating buses with minimal JWT-based security.

---

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- JWT (JSON Web Token) Security
- OpenAPI / Swagger
- Lombok

---

## Folder Structure

- `domain/` – Domain models: aggregates, commands, queries, services.
- `application/internal/` – Application logic (CommandService and QueryService).
- `infrastructure/` – Persistence, security, configuration, transformers.
- `interfaces/rest/` – Controllers, resources (DTOs), and endpoints.
- `shared/` – Shared components: auditing, global configuration, JWT.

---

## Requirements

- Java 17
- Maven
- MySQL 8+
- (Optional) MySQL Workbench for administration

---

## Configuration

Create the database:
```sql
CREATE DATABASE bus_api;
```

Configure `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bus_api
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update

jwt.secret=YourSecretKey
jwt.expiration=86400000
```

---

## Running the Application

```bash mvn spring-boot:run ```

---

## API Access

**Swagger UI**: http://localhost:8080/swagger-ui.html

**Authentication**: JWT-based security (login at `/api/v1/auth/login`)

Username: `admin`

Password: `admin123`

---

## Main Endpoints

- `POST /api/v1/auth/login` → Genera token JWT.
- `POST /api/v1/bus` → Crea un bus.
- `GET /api/v1/bus` → Lista buses paginados.
- `GET /api/v1/bus/{id}` → Obtiene un bus por ID.
---

## Best Practices & Notes

- Follows DDD: domain separated from infrastructure and presentation.

- DTOs and Assemblers are used to separate entities from resources.

- Pagination implemented in list endpoints (GET /bus).

- Global exception handling and validation recommended for improvement.

- Minimal JWT security implemented; easily extensible to roles.

---
