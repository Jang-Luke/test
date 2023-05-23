<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Modify</title>
  <style>
      * {
          box-sizing: border-box;
      }

      div {
          background-color: lightskyblue;
          border: 1px solid white;
      }

      .header {
          display: flex;
          min-height: 50px;
          text-align: center;
      }

      .no {
          flex: 1 1 0;
          max-width: 3rem;
          padding: 0.5rem;
          display: flex;
          justify-content: center;
          align-items: center;
      }

      .title {
          flex: 7 1 0;
          padding: 0.5rem;
          display: flex;
          justify-content: center;
          align-items: center;
      }

      .writer {
          flex: 2 1 0;
          max-width: 7rem;
          padding: 0.5rem;
          display: flex;
          justify-content: center;
          align-items: center;
      }

      .content-body {
          min-height: 45vh;
          padding: 0.5rem;
      }

      .footer {
          display: flex;
          justify-content: space-around;
      }

      .view-count {
          flex: 2 1 0;
          padding: 0.5rem;
      }

      .like-count {
          flex: 2 1 0;
          text-align: right;
          padding: 0.5rem;
      }
  </style>
</head>
<body>
<form action="/boards/${board.id}/modify" method="post">
<div class="container">
  <div class="header">
    <input type="text" name="id" class="no" value="${board.id}" readonly>
    <input type="text" name="title" class="title" value="${board.title}">
    <input type="text" name="writer" class="writer" value="${board.writer}" readonly>
  </div>
  <textarea class="content-body" name="content">
    ${board.content}
  </textarea>
  <div class="footer">
    <div class="view-count">
      ${board.viewCount}
    </div>
    <div class="like-count">
      ${board.likeCount}
    </div>
  </div>
</div>
  <input type="submit" value="수정하기">
</form>
<hr>
<a href="/boards">목록으로</a>
<a href="/boards/datatablelist">데이터 테이블로</a>
<a href="/">홈으로</a>
</body>
</html>
