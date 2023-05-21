<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>List</title>
</head>
<body>
<h1>MemberList</h1>
<ul>
  <c:forEach items="${members}" var="member">
    <hr>
    <li>
      id : ${member.id}
    </li>
    <li>
      username : ${member.username}
    </li>
    <li>
      age : ${member.age}
    </li>
    <hr>
  </c:forEach>
</ul>
<a href="/">return</a>
</body>
</html>