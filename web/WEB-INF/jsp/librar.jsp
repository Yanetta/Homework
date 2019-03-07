</html>
<%@page import="controller.Library"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>JSP lib Page</title>
</head>
<body>
<%
    Library library = (Library) request.getAttribute("model");
    if (library != null) {
%>
<h3>You have selected Library:</h3>
<h5>
    Id=<%=library.getId()%></h5>
<table border="2">
    <tr>
        <th>Book</th>
        <th>Year of born</th>
    </tr>
    <c:forEach items="<%=library.getBooks()%>" var="book"
               varStatus="status">
    <tr>
        <td>${book.name}</td>
        <td>${book.pages}</td>
    </tr>
    </c:forEach>
    </table>
        <%
    }
%>
</body>
</html>
