<!DOCTYPE html>
<html>
  <head>
    <title>User</title>
  </head>
  <body>
    <h1>User: ${user.id}</h1>
    <p>Name: ${user.name} ${user.lastName}</p>
    <p>Login: ${user.login}</p>
    <p>Email: ${user.email}</p>
    <p>Role: ${user.roleDto}</p>
    <br />
    <p>
      <a href="controller?command=users">
        <button>Back to all users</button>
      </a>
    </p>
    <p></p>
  </body>
</html>
