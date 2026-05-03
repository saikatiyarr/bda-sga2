<link rel="stylesheet" href="/style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Students</h2>

<c:forEach var="s" items="${students}">
    ${s.id} - ${s.name} - ${s.email} 
    <a href="/edit-student/${s.id}">Edit</a>
    <br/>
</c:forEach>

<a href="/add-student">Add Student</a>