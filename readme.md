
BDA Assignment 2 — Spring Boot CRUD Application

Student & Course Management System

* Name: Sai Katiyar
* Subject: Building Database Applications

⸻

1. Introduction

This project is a Spring Boot CRUD application developed to manage two entities: Students and Courses.

The goal of the assignment is to implement:

* Create
* Read
* Update

operations using:

* Spring Boot (backend)
* JSP (view layer)
* MySQL (database)

A relationship is established between the entities where a student can have multiple courses, and each course belongs to one student.

⸻

2. Entity Relationship Design

Relationship

* One Student → Many Courses
* Many Courses → One Student

This is implemented using:

* @OneToMany (Student side)
* @ManyToOne (Course side)

⸻

3. Project Structure

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
│
├── pom.xml

⸻

4. Tech Stack

Layer	Technology
Backend	Spring Boot, Spring MVC
Database	MySQL
ORM	JPA (Hibernate)
View	JSP + JSTL
Testing	JUnit, Mockito
Build Tool	Maven

⸻

5. Database Population

The database is populated using a data.sql file.

Student Table Data

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

Course Table Data

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

⸻

6. Implementation Details

6.1 Create Operation

* JSP forms (add-student.jsp, add-course.jsp) are used to input data
* Data is sent to controller using POST request
* Controller saves data using service layer

⸻

6.2 Read Operation

* Data is displayed using JSP pages (student-list.jsp, course-list.jsp)
* JSTL <c:forEach> is used to iterate over data
* A custom JOIN query is used to fetch course with student

Example:

@Query("SELECT c FROM Course c JOIN c.student s")
List<Course> getCoursesWithStudents();

⸻

6.3 Update Operation

* Existing data is fetched using ID
* Data is shown in form (update-student.jsp)
* After editing, updated data is saved

⸻

7. Repository Layer

* Interfaces extend JpaRepository
* Provides built-in CRUD methods

Custom query used:

@Query("SELECT c FROM Course c JOIN c.student s")

⸻

8. Service Layer

* Contains business logic
* Handles saving and fetching data
* Connects controller and repository

⸻

9. Controller Layer

* Handles HTTP requests
* Uses @GetMapping and @PostMapping
* Sends data to JSP views

⸻

10. View Layer (JSP)

* JSP used for UI
* JSTL and EL used for displaying data
* Basic CSS applied

⸻

11. Exception Handling

* Basic exception handling is implemented using try-catch in controller
* Prevents application crash on errors

⸻

12. Testing

* Unit testing done using JUnit and Mockito
* Basic test written for service layer

⸻

13. Challenges Faced

Problem	Solution
JSP not loading	Added JSP dependencies and configured view resolver
Relationship confusion	Used @OneToMany and @ManyToOne correctly
Course not saving	Added student selection in form
Data not showing	Fixed model.addAttribute() and JSTL usage
Form binding issues	Used correct field names and Lombok

⸻

14. How to Run

1. Create database:

CREATE DATABASE studentdb;

2. Update credentials in application.properties
3. Run project:

mvn spring-boot:run

4. Open:

http://localhost:8080/

⸻

15. Conclusion

This project demonstrates:

* Spring Boot CRUD operations
* JPA entity relationships
* Use of JSP with Spring MVC
* Basic testing and exception handling

The application successfully performs Create, Read, and Update operations for Students and Courses.


