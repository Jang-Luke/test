<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Title</title>
  <style>
      #column {
          width: 6rem;
      }
      #keyword{
          width: 12rem;
      }
      #keyword::placeholder{
          color: #00000070;
      }
  </style>
</head>
<body>
<h1>Welcome to MyBatis</h1>
<form action="/serchByCondition" method="get">
  <fieldset>
    <legend>SelectByCondition</legend>
    <select name="column" id="column">
      <option value="title">제목</option>
      <option value="genre">장르</option>
    </select>
    <input type="text" name="keyword" id="keyword" placeholder="검색어 입력">
    <input type="submit" value="검색">
  </fieldset>
</form>
<form action="/serchByMultiCondition" method="get">
  <fieldset>
    <legend>SelectByMultiCondition</legend>
    <select name="genre">
      <option value="액션">액션</option>
      <option value="드라마">드라마</option>
      <option value="스릴러">스릴러</option>
      <option value="SF">SF</option>
      <option value="호러">호러</option>
    </select>
    <input type="text" name="title" id="title" placeholder="제목">
    <input type="submit" value="검색">
  </fieldset>
</form>
<hr>
<c:forEach items="${movies}" var="i">
  <div class="id-result">${i.id}</div>
  <div class="title-result">${i.title}</div>
  <div class="genre-result">${i.genre}</div>
</c:forEach>
</body>
</html>
