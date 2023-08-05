<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Edit book</title>
  </head>
  <body>
    <jsp:include page="navbar.jsp" />
    <h1>Edit book</h1>
    <form method="post" action="controller">
      <input name="command" type="hidden" value="edit_book" />
      <input name="id" type="hidden" value="${requestScope.book.id}" />
      <label for="title">Title:</label>
      <input
        id="title"
        name="title"
        type="text"
        required
        value="${requestScope.book.title}"
      />
      <br />
      <label for="author">Author:</label>
      <input
        id="author"
        name="author"
        type="text"
        required
        value="${requestScope.book.author}"
      />
      <br />
      <label for="year">Year:</label>
      <input
        id="year"
        name="year"
        type="text"
        value="${requestScope.book.year}"
      />
      <br />
      <label for="price">Price:</label>
      <input
        id="price"
        name="price"
        type="text"
        required
        value="${requestScope.book.price}"
      />
      <br />
      <label for="pages">Pages:</label>
      <input
        id="pages"
        name="pages"
        type="text"
        value="${requestScope.book.pages}"
      />
      <br />
      <label for="isbn">ISBN:</label>
      <input
        id="isbn"
        name="isbn"
        type="text"
        required
        value="${requestScope.book.isbn}"
      />
      <br />
      <legend>Choose book's cover</legend>
      <div>
        <input
          id="HARD"
          type="radio"
          name="cover"
          value="HARD"
          <c:if test="${requestScope.book.coverDto eq 'HARD'}">checked</c:if>
        />
        <label for="HARD">HARD</label>
      </div>
      <div>
        <input
          id="SOFT"
          type="radio"
          name="cover"
          value="SOFT"
          <c:if test="${requestScope.book.coverDto eq 'SOFT'}">checked</c:if>
          />
        <label for="SOFT">SOFT</label>
      </div>
      <div>
        <input
          id="OTHER"
          type="radio"
          name="cover"
          value="OTHER"
          <c:if test="${requestScope.book.coverDto eq 'OTHER'}">checked</c:if>
          />
        <label for="OTHER">OTHER</label>
      </div>
      <br />
      <input type="submit" value="UPDATE" />
    </form>
      <p>
        <a href="controller?command=books">
          <button>Back to all books</button>
        </a>
      </p>
  </body>
</html>
