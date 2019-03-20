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
        <th>Name</th>
    </tr>
    <c:forEach items="<%=library.getBooks()%>" var="book"
               varStatus="status">
    <tr>
        <td>${book.sort}</td>
        <td>${book.pages}</td>
    </tr>
    </c:forEach>
    </table>
        <%
    }
%>
    <FORM METHOD="GET" action="/Homework_war_exploded/book/libr">
    <INPUT TYPE="SUBMIT" VALUE="Return">
</FORM>
</body>
</html>
