<link rel="stylesheet" href="/style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Courses</h2>

<c:forEach var="c" items="${courses}">
    ${c.title} (${c.credits}) - Student: ${c.student.name}
    <br/>
</c:forEach>

<a href="/add-course">Add Course</a>