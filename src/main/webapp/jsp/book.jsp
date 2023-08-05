<!DOCTYPE html>
<html>
  <head>
    <title>Book</title>
  </head>
  <body>
    <h1>Book: ${book.id}</h1>
    <p>Title: ${book.title}</p>
    <p>Author: ${book.author}</p>
    <p>Publication date: ${book.year}</p>
    <p>Price: ${book.price} euro</p>
    <p>ISBN: ${book.isbn}</p>
    <br />
    <p>
      <form method="post" action="controller">
        <input type="hidden" name="command" value="delete_book"/>
        <input type="hidden" name="id" value="${book.id}"/>
        <input type="submit"  value="Delete"/>
      </form>
    </p>
    <p>
      <a href="controller?command=books">
        <button>Back to all books</button>
      </a>
    </p>
  </body>
</html>
