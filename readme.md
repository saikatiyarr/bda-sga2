# BDA Assignment 2 — Spring Boot CRUD Application

## Student & Course Management System

**Name:** Sai Katiyar
**Subject:** Building Database Applications  

---

## 1. Introduction

This project is a Spring Boot CRUD application developed to manage two entities: **Students** and **Courses**.

The goal of the assignment is to implement:

- Create  
- Read  
- Update  

Using:

- Spring Boot (Backend)  
- JSP (View Layer)  
- MySQL (Database)  

A relationship is established where:

- One student can have multiple courses  
- Each course belongs to one student  

---

## 2. Entity Relationship Design

### Relationship

- One Student → Many Courses  
- Many Courses → One Student  

### Annotations Used

- `@OneToMany` (Student side)  
- `@ManyToOne` (Course side)  

---

## 3. Project Structure

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

## 4. Tech Stack

| Layer       | Technology               |
|------------|--------------------------|
| Backend    | Spring Boot, Spring MVC  |
| Database   | MySQL                    |
| ORM        | JPA (Hibernate)          |
| View       | JSP + JSTL               |
| Testing    | JUnit, Mockito           |
| Build Tool | Maven                    |

---

## 5. Database Population

### Student Table Data

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

### Course Table Data

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

## 6. Implementation Details

### 6.1 Create Operation

- JSP forms (`add-student.jsp`, `add-course.jsp`) used for input  
- Data sent via POST request  
- Controller saves data through service layer  

### 6.2 Read Operation

- Data displayed using JSP (`student-list.jsp`, `course-list.jsp`)  
- JSTL `<c:forEach>` used for iteration  
- Custom JOIN query used  

```java
@Query("SELECT c FROM Course c JOIN c.student s")
List<Course> getCoursesWithStudents();
```

### 6.3 Update Operation

- Fetch data by ID  
- Display in form (`update-student.jsp`)  
- Save updated data  

---

## 7. Repository Layer

- Interfaces extend `JpaRepository`  
- Provides built-in CRUD methods  

Custom query:

```java
@Query("SELECT c FROM Course c JOIN c.student s")
```

---

## 8. Service Layer

- Contains business logic  
- Handles data operations  
- Connects controller and repository  

---

## 9. Controller Layer

- Handles HTTP requests  
- Uses `@GetMapping` and `@PostMapping`  
- Sends data to JSP views  

---

## 10. View Layer (JSP)

- JSP used for UI  
- JSTL and EL for rendering  
- Basic CSS styling  

---

## 11. Exception Handling

- Basic try-catch used in controllers  
- Prevents application crashes  

---

## 12. Testing

- Unit testing using JUnit and Mockito  
- Basic service layer tests implemented  

---

## 13. Challenges Faced

| Problem                  | Solution                                      |
|------------------------|----------------------------------------------|
| JSP not loading        | Added dependencies and view resolver         |
| Relationship confusion | Used proper annotations                      |
| Course not saving      | Added student selection in form              |
| Data not showing       | Fixed `model.addAttribute()` and JSTL usage  |
| Form binding issues    | Correct field names and Lombok               |

---

## 14. How to Run

### 1. Create Database

```sql
CREATE DATABASE studentdb;
```

### 2. Configure Credentials  
Update `application.properties`

### 3. Run Project

```bash
mvn spring-boot:run
```

### 4. Open in Browser

http://localhost:8080/

---

## 15. Conclusion

This project demonstrates:

- Spring Boot CRUD operations  
- JPA entity relationships  
- JSP with Spring MVC  
- Basic testing and exception handling  

The application successfully performs Create, Read, and Update operations for Students and Courses.
