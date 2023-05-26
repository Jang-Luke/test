<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Item</title>
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
      .file-container{
          margin: auto;
          width: 80vw;
          display: flex;
          flex-wrap: wrap;
      }
      .file-form{
          width: 12rem;
      }
      .file-img {
          width: 100%;
          height: 12rem;
      }
      .hidden{
          display: none;
      }
  </style>
</head>
<body>
<div class="container">
  <div class="header">
    <div class="no">${board.id}</div>
    <div class="title">${board.title}</div>
    <div class="writer">${board.writer}</div>
  </div>
  <div class="content-body">
    ${board.content}
  </div>
  <div class="footer">
    <div class="view-count">
      ${board.viewCount}
    </div>
    <div class="like-count">
      ${board.likeCount}
    </div>
  </div>
</div>
<c:if test="${files!=null}">
  <button id="spread-button" type="button">파일 보기</button>
</c:if>
<div class="file-container hidden">
  <c:forEach items="${files}" var="file">
    <div class="file-form">
      <img src="/upload/${file.sysName}" alt="Oops" class="file-img">
    </div>
  </c:forEach>
</div>
<hr>
<c:if test="${sessionScope.loginId == board.writer}">
  <a href="/boards/${board.id}/delete">삭제하기</a>
  <a href="/boards/${board.id}/modify">수정하기</a>
</c:if>
<a href="/boards">목록으로</a>
<a href="/">홈으로</a>
<script>
  document.querySelector('#spread-button').addEventListener('click', function() {
      document.querySelector('.file-container').className = 'file-container';
  });
</script>
</body>
</html>