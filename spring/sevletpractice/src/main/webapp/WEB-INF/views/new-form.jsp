<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>new-form</title>
</head>
<body>
<form action="save" method="post">
  이름 : <input type="text" name="username" id="username"><br>
  나이 : <input type="text" name="age" id="age"><br>
  <input type="submit" value="확인">
  <a href="/">
    <button type="button">돌아가기</button>
  </a>
</form>
</body>
</html>
