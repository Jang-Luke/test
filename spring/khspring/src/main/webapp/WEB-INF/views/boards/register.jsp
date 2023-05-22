<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Register</title>
</head>
<body>
<form action="/boards" method="post">
  <input type="hidden" name="writer" value="${sessionScope.loginId}">
  <input type="text" name="title" id="title" placeholder="제목">
  <input type="text" name="content" id="content" placeholder="내용">
  <hr>
  <input type="submit" value="작성하기">
</form>
</body>
</html>
