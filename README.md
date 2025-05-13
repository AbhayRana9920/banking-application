# Bank App REST API

## Project Description

A simple Spring Boot 3 application providing a RESTful Banking API. It allows users to:

- Create a new bank account
- Deposit and withdraw money
- Check the account balance
- Delete accounts

The application uses **Spring Data JPA (Hibernate)** to interact with a **MySQL** database. Basic exception handling is included to handle scenarios like invalid account IDs or insufficient funds. This project demonstrates common CRUD operations and best practices in a Spring Boot REST service.

---

## Features

- 🏦 **Create Bank Account**: Register a new bank account with an initial balance.
- 💰 **Deposit Money**: Add funds to an existing account by specifying an amount.
- 💸 **Withdraw Money**: Withdraw funds from an account (withdrawals will fail if there are insufficient funds).
- 💳 **View Account Balance**: Retrieve the current balance of a specific account.
- 🗑️ **Delete Account**: Remove a bank account from the system by ID.
- ⚠️ **Exception Handling**: Handles errors such as non-existent account IDs or invalid transaction amounts.
- 📩 **API Testing with Postman**: Easily test all endpoints using Postman collections.

---

## Tech Stack

- 🌱 **Spring Boot 3**
- 🗄️ **Spring Data JPA (Hibernate)**
- 🐬 **MySQL 8.x**
- ✏️ **Lombok**
- 🌐 **Spring Web**
- 🧪 **Postman (for API Testing)**

---

## Database Configuration

Database connection properties are defined in `src/main/resources/application.properties`. Configure your MySQL connection as follows:

```properties
spring.datasource.url=jdbc:mysql://<HOST>:<PORT>/<DB_NAME>
spring.datasource.username=<USERNAME>
spring.datasource.password=<PASSWORD>
spring.jpa.hibernate.ddl-auto=update
```

---

## How to Run Locally

Clone the repository:

```bash
git clone https://github.com/AbhayRana9920/banking-application.git
```

Build and run the project:

```bash
cd bank-app-rest-api
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

---

## API Endpoints

| HTTP Method | Endpoint                     | Description                          |
|-------------|------------------------------|--------------------------------------|
| POST        | `/api/accounts`              | Create a new bank account            |
| POST        | `/api/accounts/{id}/deposit` | Deposit money into an account        |
| POST        | `/api/accounts/{id}/withdraw`| Withdraw money from an account       |
| GET         | `/api/accounts/{id}`         | Get the current account balance      |
| DELETE      | `/api/accounts/{id}`         | Delete the specified account         |

Note: For deposit and withdraw operations, provide a JSON body like:

```json
{
  "amount": 100.00
}
```
