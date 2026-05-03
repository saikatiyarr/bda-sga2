<link rel="stylesheet" href="/style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/save-course" method="post">
    Title: <input type="text" name="title"/>
    Credits: <input type="number" name="credits"/>

    Student:
    <select name="student.id">
        <c:forEach var="s" items="${students}">
            <option value="${s.id}">${s.name}</option>
        </c:forEach>
    </select>

    <button type="submit">Save</button>
</form>