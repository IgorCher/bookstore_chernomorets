<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>All Users</h1>
<table>
<tr>
    <th>#</th>
    <th>Id</th>
    <th>Email</th>
    <th>Name</th>
    <th>Last Name</th>
<tr>
<c:forEach items="${users}" var="user" varStatus="counter">
    <tr>
        <td>${counter.count}</td>
        <td>${user.id}</td>
        <td><a href ="controller?command=user&id=${user.id}">${user.email}</a></td>
        <td>${user.name}</td>
        <td>${user.lastName}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>