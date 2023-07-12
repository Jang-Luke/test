<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Register</title>
  <style>
    .container{
        margin: auto;
        width: 90vw;
    }
    #title{
        display: block;
        width: 100%;
        padding: 5px;
    }
    #content{
        display: block;
        width: 100%;
        min-height: 350px;
        padding: 5px;
    }
  </style>
</head>
<body>
<form action="/boards" method="post" enctype="multipart/form-data">
  <div class="container">
    <input type="hidden" name="writer" value="${sessionScope.loginId}">
    <input type="text" name="title" id="title" placeholder="제목">
    <textarea name="content" id="content" cols="30" rows="10" placeholder="내용"></textarea>
    <input type="file" name="files" id="files" multiple>
  </div>
  <hr>
  <input type="submit" value="작성하기">
</form>
<hr>
<a href="/boards">목록으로</a>
<a href="/boards/datatablelist">데이터 테이블로</a>
<a href="/">홈으로</a>
</body>
</html>
