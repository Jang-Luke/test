<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <title>Document</title>
  <style>
    .font-size-title{
      font-size: 16pt;
      font-weight: bold;
      text-align: center;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-12">
      <p class="font-size-title">자유게시판</p>
    </div>
  </div>
</div>

<table border="1" width="800">
  <tr>
    <th colspan="5">자유게시판</th>
  </tr>
  <tr>
    <td width="20">#</td>
    <td width="540" align="center">제목</td>
    <td width="100" align="center">작성자</td>
    <td width="100" align="center">날짜</td>
    <td width="40" align="center">조회</td>
  </tr>
  <tr>
    <td colspan="5" align="center" height="500">표시할 내용이 없습니다.</td>
  </tr>
  <tr>
    <td colspan="5" align="center">
      <a href="">1</a>
      <a href="">2</a>
      <a href="">3</a>
      <a href="">4</a>
      <a href="">5</a>
      <a href="">6</a>
      <a href="">7</a>
      <a href="">8</a>
      <a href="">9</a>
      <a href="">10</a>
    </td>
  </tr>
  <tr>
    <td colspan="5" align="right">
      <a href="/board/writeForm.jsp">
        <button>작성하기</button></a>
    </td>
  </tr>
</table>
</body>
</html>