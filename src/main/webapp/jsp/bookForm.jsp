<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Create book</title>
  </head>
  <body>
    <h1>Create new book</h1>
    <form method="post" action="controller">
      <input name="command" type="hidden" value="create_book" />
      <label for="title">Title:</label>
      <input id="title" name="title" type="text" required />
      <br />
      <label for="author">Author:</label>
      <input id="author" name="author" type="text" required />
      <br />
      <label for="year">Year:</label>
      <input id="year" name="year" type="text" />
      <br />
      <label for="price">Price:</label>
      <input id="price" name="price" type="text" required />
      <br />
      <label for="pages">Pages:</label>
      <input id="pages" name="pages" type="text" />
      <br />
      <label for="isbn">ISBN:</label>
      <input id="isbn" name="isbn" type="text" required />
      <br />
      <legend>Choose book's cover</legend>
      <div>
        <input type="radio" id="HARD" name="cover" value="HARD" />
        <label for="HARD">HARD</label>
      </div>
      <div>
        <input type="radio" id="SOFT" name="cover" value="SOFT" />
        <label for="SOFT">SOFT</label>
      </div>
      <div>
        <input type="radio" id="OTHER" name="cover" value="OTHER" />
        <label for="OTHER">OTHER</label>
      </div>
      <br />
      <input type="submit" value="CREATE" />
    </form>
  </body>
</html>
