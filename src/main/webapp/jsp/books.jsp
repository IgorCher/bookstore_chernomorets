<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Books</title>
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
<tr>
<c:forEach items="${books}" var="book" varStatus="counter">
    <tr>
        <td>${counter.count}</td>
        <td>${book.id}</td>
        <td><a href ="controller?command=book&id=${book.id}">${book.title}</a></td>
        <td>${book.author}</td>
        <td>${book.year}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>