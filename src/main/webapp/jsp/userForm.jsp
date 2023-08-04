<%@page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<h1>Create new user</h1>
<form method="post" action="controller">
    <input name="command" type="hidden" value="create_user">
    <label for="name">Name:</label>
    <input id="name" name="name" type="text">
    <br/>
    <label for="last_name">Last name:</label>
    <input id="last_name" name="last_name" type="text">
    <br/>
    <label for="email">Email:</label>
    <input id="email" name="email" type="email">
    <br/>
    <label for="login">Login:</label>
    <input id="login" name="login" type="text">
    <br/>
    <label for="password">Password:</label>
    <input id="password" name="password" type="password">
    <br/>
        <legend>Choose user's role</legend>
        <div>
          <input type="radio" id="ADMIN" name="role" value="ADMIN" />
          <label for="ADMIN">ADMIN</label>
        </div>
        <div>
          <input type="radio" id="MANAGER" name="role" value="MANAGER" />
          <label for="MANAGER">MANAGER</label>
        </div>
        <div>
            <input type="radio" id="CUSTOMER" name="role" value="CUSTOMER" />
            <label for="CUSTOMER">CUSTOMER</label>
          </div>

    <br/>
    <input type="submit" value="CREATE">
</form>
</body>
</html>