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
      <a href="controller?command=books">
        <button>Back to all books</button>
      </a>
    </p>
  </body>
</html>
