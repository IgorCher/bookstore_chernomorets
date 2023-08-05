<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Books</title>
  </head>
  <body>
    <h1>All Books</h1>
    <table>
      <tr>
        <th>#</th>
        <th>Id</th>
        <th>Title</th>
        <th>Author</th>
        <th>Year</th>
        <th>Cover</th>
        <th>Price</th>
      </tr>

      <tr>
        <c:forEach items="${books}" var="book" varStatus="counter">
          <tr>
            <td>${counter.count}</td>
            <td>${book.id}</td>
            <td>
              <a href="controller?command=book&id=${book.id}">${book.title}</a>
            </td>
            <td>${book.author}</td>
            <td>${book.year}</td>
            <td>${book.coverDto}</td>
            <td>${book.price}</td>
            <td>
              <a href="controller?command=edit_book_form&id=${book.id}">
                <button>Edit</button>
              </a>
            </td>
          </tr>
        </c:forEach>
      </tr>
    </table>
  </body>
</html>
