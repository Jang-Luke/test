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
  <textarea name="content" id="content" cols="30" rows="10" placeholder="내용"></textarea>
  <hr>
  <input type="submit" value="작성하기">
</form>
<hr>
<a href="/boards">목록으로</a>
<a href="/boards/datatablelist">데이터 테이블로</a>
<a href="/">홈으로</a>
</body>
</html>
