<link rel="stylesheet" href="/style.css">
<form action="/save-student" method="post">
    <input type="hidden" name="id" value="${student.id}"/>

    name: <input type="text" name="name" value="${student.name}"/>
    email: <input type="text" name="email" value="${student.email}"/>

    <button type="submit">Update</button>
</form>