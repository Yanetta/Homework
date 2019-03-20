<%--
  Created by IntelliJ IDEA.
  User: witch
  Date: 03.03.2019
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
  <%--<head>--%>
    <%--<title>$Title$</title>--%>
  <%--</head>--%>
  <%--<body>--%>
  <%--$END$fjgkjdfkdjffn--%>
  <%--</body>--%>
</html>
<%@page import="xmljson.MateGroup"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>JSP Page</title>
</head>
<body>
<h1>Hello Mate!</h1>
<FORM METHOD="GET" action="/Homework_war_exploded/jspp">
  Please enter groupId: <BR>
  <TEXTAREA NAME="groupId" ROWS="1"></TEXTAREA>
  <BR> <INPUT TYPE="SUBMIT" VALUE="Submit">
</FORM>

<%
  MateGroup mateGroup = (MateGroup) request.getAttribute("model");
  if (mateGroup != null) {
%>
<h3>You have selected mateGroup:</h3>
<h5>
  Id=<%=mateGroup.getId()%></h5>
<table border="2">
  <tr>
    <th>Student</th>
    <th>Year of born</th>
  </tr>
  <c:forEach items="<%=mateGroup.getStudents()%>" var="student"
             varStatus="status">
    <tr>
      <td>${student.sort}</td>
      <td>${student.yearOfBorn}</td>
    </tr>
  </c:forEach>
</table>
<h5>room on ${model.room.street} street, in ${model.room.city}</h5>
<ul>
  <li><%=mateGroup.getHumanResources()%></li>
</ul>
<%=mateGroup%>
<%
  }
%>
</body>
</html>