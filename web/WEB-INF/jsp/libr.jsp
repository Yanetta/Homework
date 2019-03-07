
</html>
<%@page import="controller.Library"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>JSP lib Page</title>
</head>
<body>
<h1>Hello book worm!</h1>
<FORM METHOD="GET" action="/Homework_war_exploded/book/libr">
    Please enter LibraryId: <BR>
    <TEXTAREA NAME="id" ROWS="1"></TEXTAREA>
    <BR> <INPUT TYPE="SUBMIT" VALUE="Submit">
</FORM>

<%
    Library library = (Library) request.getAttribute("model");
    if (library != null) {
%>
<h3>You have selected mateGroup:</h3>
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
<%--</table>--%>
<%--<h5>room on ${model.room.street} street, in ${model.room.city}</h5>--%>
<%--<ul>--%>
    <%--<li><%=mateGroup.getHumanResources()%></li>--%>
<%--</ul>--%>
<%=library%>
<%
    }
%>
</body>
</html>