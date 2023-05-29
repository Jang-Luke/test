<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Board List</title>
  <style>
      *{
          box-sizing: border-box;
      }
      div{
          background-color:lightskyblue;
          border: 1px solid white;
      }
      .container {
          width: 90vw;
          margin: auto;
      }

      .row {
          width: 100%;
          min-height: 2.5rem;
          display: flex;
      }

      .no {
          flex: 1 1 0;
          display: flex;
          justify-content: center;
          align-items: center;
      }

      .writer {
          flex: 5 1 0;
          display: flex;
          justify-content: center;
          align-items: center;
      }

      .title {
          flex: 10 1 0;
          display: flex;
          justify-content: center;
          align-items: center;
      }

      .view-count {
          flex: 1 1 0;
          display: flex;
          justify-content: center;
          align-items: center;
      }

      .like-count {
          flex: 1 1 0;
          display: flex;
          justify-content: center;
          align-items: center;
      }

      .write-date {
          flex: 3 1 0;
          display: flex;
          justify-content: center;
          align-items: center;
      }
      .links {
          display: flex;
          justify-content: space-between;
          background: none;
      }
  </style>
</head>
<body>
<div class="container">
  <c:forEach items="${boards}" var="i">
    <div class="row">
      <div class="no">
          ${i.id}
      </div>
      <div class="writer">
          ${i.writer}
      </div>
      <div class="title">
        <a href="/boards/${i.id}">
            ${i.title}
        </a>
      </div>
      <div class="view-count">
          ${i.viewCount}
      </div>
      <div class="like-count">
          ${i.likeCount}
      </div>
      <div class="write-date">
          ${i.formedWriteDate}
      </div>
    </div>
  </c:forEach>
</div>
<hr>
<div class="links">
  <a href="/">홈으로</a>
  <a href="/boards/register">작성하기</a>
</div>
</body>
</html>
