# Design-Splitwise

# Design-Splitwise Backend

A backend system inspired by **Splitwise**, implemented in **Java Spring Boot** with **MySQL**.  
This project allows users to manage groups, record expenses, and automatically settle debts with minimal transactions.

---

## Features

- **User Management**
  - Create and manage users.
- **Group Management**
  - Create groups with members and assign an admin.
  - Add expenses to groups.
- **Expense Management**
  - Track who paid and who owes.
  - Support multiple users per expense with paid/had-to-pay tracking.
- **Automatic Settlement**
  - Calculate minimal transactions to settle balances among group members.
  - Transaction history saved in the database.

---

## Technology Stack

- **Backend:** Java 17, Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA, Hibernate
- **Auditing:** @CreatedDate and @LastModifiedDate for tracking entities
- **Build Tool:** Maven
- **Testing:** JUnit 5

---

## Installation

1. Clone the repository:

```bash
git clone https://github.com/Print-Adarsh/Design-Splitwise.git
cd Design-Splitwise



2.Configure MySQL database in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/splitwise
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update


3 Build and run the application 

mvn clean install
mvn spring-boot:run

4...API Endpoints
User APIs

POST /user – Create a new user

Group APIs

POST /group – Create a new group

POST /expense/{groupId} – Add expense to a group

GET /group/settle/{groupId} – Settle up transactions for a group
