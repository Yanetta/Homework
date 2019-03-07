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
</body>
</html>