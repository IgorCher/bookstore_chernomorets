<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<h1>Edit user</h1>
<form method="post" action="controller">
    <input name="command" type="hidden" value="edit_user">
    <label for="id">ID:</label>
    <input id="id" name="id" type="text" value="${requestScope.user.id}">
    <br/>
    <label for="name">Name:</label>
    <input id="name" name="name" type="text" value="${requestScope.user.name}">
    <br/>
    <label for="last_name">Last name:</label>
    <input id="last_name" name="last_name" type="text" value="${requestScope.user.lastName}">
    <br/>
    <label for="email">Email:</label>
    <input id="email" name="email" type="email" value="${requestScope.user.email}">
    <br/>
    <label for="login">Login:</label>
    <input id="login" name="login" type="text" value="${requestScope.user.login}">
    <br/>
    <label for="password">Password:</label>
    <input id="password" name="password" type="password" value="${requestScope.user.password}">
    <br/>
        <legend>Choose user's role</legend>
        <div>
          <input type="radio" id="ADMIN" name="role" value="ADMIN" <c:if test="${requestScope.user.roleDto eq 'ADMIN'}">checked</c:if>>
          <label for="ADMIN">ADMIN</label>
        </div>
        <div>
          <input type="radio" id="MANAGER" name="role" value="MANAGER" <c:if test="${requestScope.user.roleDto eq 'MANAGER'}">checked</c:if>>
          <label for="MANAGER">MANAGER</label>
        </div>
        <div>
            <input type="radio" id="CUSTOMER" name="role" value="CUSTOMER" <c:if test="${requestScope.user.roleDto eq 'CUSTOMER'}">checked</c:if>>
            <label for="CUSTOMER">CUSTOMER</label>
        </div>
    <br/>
    <input type="submit" value="UPDATE">
</form>
</body>
</html>