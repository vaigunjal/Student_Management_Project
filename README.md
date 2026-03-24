 # Student Record Management – Spring Boot API

## 📌 Overview

This project is a Spring Boot REST API for managing student records with authentication, validation, and business logic.

---

## 🚀 Tech Stack

* Java 17+
* Spring Boot
* Spring Security (Authentication JWT Based)
* Spring Data JPA
* MySQL 

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
https://github.com/vaigunjal/Student_Management_Project.git
```

### 2. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3. Run the Application

```bash
mvn spring-boot:run
```

Application will start at:

```
http://localhost:8080
```

---

## 🔐 Authentication

This project uses JWT (JSON Web Token) for authentication.

🔹 Step 1: Login to Get Token
API:

POST /api/auth/login

Request Body:

{
  "username": "admin",
  "password": "password"
}

Response:

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}

### ✅ Sample Credentials

```
Username: admin
Password: password
```

---

## 📌 API Endpoints

| Method | Endpoint           | Description      |
| ------ | ------------------ | ---------------- |
| POST   | /api/students      | Create student   |
| GET    | /api/students      | Get all students |
| PUT    | /api/students/{id} | Update student   |
| DELETE | /api/students/{id} | Delete student   |

---

## 📥 Sample Payload

### ➤ Create Student (POST /api/students)

```json
{
  "name": "Vaishnavi",
  "age": 22,
  "marks1": 80,
  "marks2": 75,
  "marks3": 90,
  "marks4": 85,
  "marks5": 70
}
```

---

## 📤 Sample Response

```json
{
  "id": 1,
  "name": "Vaishnavi",
  "age": 22,
  "marks1": 80,
  "marks2": 75,
  "marks3": 90,
  "marks4": 85,
  "marks5": 70,
  "percentage": 80.0,
  "division": "First Division"
}
```

---

## ❌ Validation Rules

* Name → Required, minimum 3 characters
* Age → Between 5 and 25
* Marks → 0 to 100

### Example Error Response (400 BAD REQUEST)

```json
{
  "name": "Name must be at least 3 characters",
  "age": "Age must be <= 25",
  "marks1": "Marks must be between 0 and 100"
}
```

---

## 🧪 cURL Examples

### 🔹 Create Student

```bash
curl -u Authorization: Bearer <your_token> -X POST http://localhost:8080/api/students \
-H "Content-Type: application/json" \
-d '{
  "name": "John",
  "age": 20,
  "marks1": 70,
  "marks2": 75,
  "marks3": 80,
  "marks4": 85,
  "marks5": 90
}'
```

---

### 🔹 Get All Students

```bash
curl -u Authorization: Bearer <your_token> http://localhost:8080/api/students
```

---

### 🔹 Update Student

```bash
curl -u Authorization: Bearer <your_token> -X PUT http://localhost:8080/api/students/1 \
-H "Content-Type: application/json" \
-d '{
  "name": "Updated Name",
  "age": 21,
  "marks1": 80,
  "marks2": 80,
  "marks3": 80,
  "marks4": 80,
  "marks5": 80
}'
```

---

### 🔹 Delete Student

```bash
curl -u Authorization: Bearer <your_token> -X DELETE http://localhost:8080/api/students/1
```

---

## 📮 Postman Testing

1. Open Postman
2. Select **Headers**
3. Enter:

 Key: Authorization Value:
 Bearer <your_token>
5. Test all endpoints

---

## 🧠 Business Logic

* Percentage = Average of 5 marks
* Division:

  * ≥ 60 → First Division
  * ≥ 50 → Second Division
  * < 50 → Fail

---

## 📌 Notes

* All `/api/students/**` endpoints are secured
* Validation handled using `@Valid` and global exception handler
* Clean layered architecture (Controller → Service → Repository)

---

## 👨‍💻 Author

Vaishnavi Gunjal
