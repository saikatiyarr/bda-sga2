# 📚 BDA Assignment 2 — Spring Boot CRUD Application

## 🎓 Student & Course Management System

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Framework-brightgreen)
![Java](https://img.shields.io/badge/Java-Backend-orange)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)

**👤 Name:** Sai Katiyar 
**📘 Subject:** Building Database Applications  

---

## 🚀 1. Introduction

This project is a **Spring Boot CRUD application** to manage:

- 👨‍🎓 Students  
- 📘 Courses  

### 🎯 Features Implemented

- ✅ Create  
- ✅ Read  
- ✅ Update  

### 🛠️ Tech Used

- Spring Boot (Backend)  
- JSP (View Layer)  
- MySQL (Database)  

### 🔗 Relationship

> One student can have multiple courses, and each course belongs to one student.

---

## 🧩 2. Entity Relationship Design

### 🔁 Relationship Mapping

- **1 Student → Many Courses**  
- **Many Courses → 1 Student**

### 🏷️ Annotations

- `@OneToMany` → Student  
- `@ManyToOne` → Course  

---

## 📁 3. Project Structure

```bash
student-course-crud/
├── src/
│   ├── main/
│   │   ├── java/com/example/studentcourse/
│   │   │   ├── StudentCourseApplication.java
│   │   │   ├── model/
│   │   │   │   ├── Student.java
│   │   │   │   └── Course.java
│   │   │   ├── repository/
│   │   │   │   ├── StudentRepository.java
│   │   │   │   └── CourseRepository.java
│   │   │   ├── service/
│   │   │   │   ├── StudentService.java
│   │   │   │   └── CourseService.java
│   │   │   └── controller/
│   │   │       ├── HomeController.java
│   │   │       ├── StudentController.java
│   │   │       └── CourseController.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   ├── data.sql
│   │   │   └── static/style.css
│   │   └── webapp/WEB-INF/jsp/
│   │       ├── home.jsp
│   │       ├── student-list.jsp
│   │       ├── course-list.jsp
│   │       ├── add-student.jsp
│   │       ├── add-course.jsp
│   │       └── update-student.jsp
│   └── test/
│       └── java/com/example/studentcourse/
│           └── StudentServiceTest.java
├── pom.xml
```

---

## 🧰 4. Tech Stack

| Layer       | Technology               |
|------------|--------------------------|
| 🖥️ Backend | Spring Boot, Spring MVC  |
| 🗄️ Database | MySQL                    |
| 🔄 ORM     | JPA (Hibernate)          |
| 🎨 View    | JSP + JSTL               |
| 🧪 Testing | JUnit, Mockito           |
| 📦 Build   | Maven                    |

---

## 🗃️ 5. Database Population

### 👨‍🎓 Student Data

```sql
INSERT INTO student (name, email) VALUES ('Rahul', 'rahul@gmail.com');
INSERT INTO student (name, email) VALUES ('Amit', 'amit@gmail.com');
INSERT INTO student (name, email) VALUES ('Aman', 'aman@gmail.com');
INSERT INTO student (name, email) VALUES ('Arpit', 'arpit@gmail.com');
INSERT INTO student (name, email) VALUES ('Vijay', 'vijay@gmail.com');
INSERT INTO student (name, email) VALUES ('Sanjay', 'Sanjay@gmail.com');
INSERT INTO student (name, email) VALUES ('Rohit', 'rohit@gmail.com');
INSERT INTO student (name, email) VALUES ('Simran', 'simran@gmail.com');
INSERT INTO student (name, email) VALUES ('Akansha', 'akansha@gmail.com');
INSERT INTO student (name, email) VALUES ('Vaidya', 'Vaidya@gmail.com');
```

### 📘 Course Data

```sql
INSERT INTO course (title, credits, student_id) VALUES ('Math', 4, 1);
INSERT INTO course (title, credits, student_id) VALUES ('Physics', 3, 1);
INSERT INTO course (title, credits, student_id) VALUES ('Chemistry', 5, 1);
INSERT INTO course (title, credits, student_id) VALUES ('English', 3, 1);
INSERT INTO course (title, credits, student_id) VALUES ('Hindi', 4, 1);
INSERT INTO course (title, credits, student_id) VALUES ('Music', 6, 1);
INSERT INTO course (title, credits, student_id) VALUES ('Database', 5, 1);
INSERT INTO course (title, credits, student_id) VALUES ('OS', 6, 1);
INSERT INTO course (title, credits, student_id) VALUES ('Environmental', 3, 1);
INSERT INTO course (title, credits, student_id) VALUES ('ML', 3, 1);
```

---

## ⚙️ 6. Implementation Details

### ➕ Create

- Forms: `add-student.jsp`, `add-course.jsp`  
- POST request to controller  
- Service layer saves data  

### 📖 Read

- Display: `student-list.jsp`, `course-list.jsp`  
- JSTL `<c:forEach>` used  
- JOIN query implemented  

```java
@Query("SELECT c FROM Course c JOIN c.student s")
List<Course> getCoursesWithStudents();
```

### ✏️ Update

- Fetch by ID  
- Show in form  
- Save updated data  

---

## 🧱 7. Architecture Layers

### 📦 Repository Layer
- Extends `JpaRepository`
- Provides CRUD operations  

### 🧠 Service Layer
- Business logic  
- Connects controller & repository  

### 🌐 Controller Layer
- Handles HTTP requests  
- Uses `@GetMapping`, `@PostMapping`  

### 🎨 View Layer
- JSP + JSTL  
- Basic CSS styling  

---

## ⚠️ 8. Exception Handling

- Try-catch blocks in controllers  
- Prevents application crashes  

---

## 🧪 9. Testing

- JUnit + Mockito  
- Service layer unit tests  

---

## 🧩 10. Challenges Faced

| ❌ Problem              | ✅ Solution                                  |
|------------------------|---------------------------------------------|
| JSP not loading        | Configured view resolver                    |
| Relationship confusion | Correct use of annotations                  |
| Course not saving      | Added student selection                     |
| Data not showing       | Fixed `model.addAttribute()`                |
| Form binding issues    | Correct field names + Lombok                |

---

## ▶️ 11. How to Run

### 1️⃣ Create Database

```sql
CREATE DATABASE studentdb;
```

### 2️⃣ Configure
Update `application.properties`

### 3️⃣ Run

```bash
mvn spring-boot:run
```

### 4️⃣ Open

👉 http://localhost:8080/

---

## 🎉 12. Conclusion

This project demonstrates:

- ✔️ Spring Boot CRUD operations  
- ✔️ JPA relationships  
- ✔️ JSP with Spring MVC  
- ✔️ Basic testing & exception handling  

---
