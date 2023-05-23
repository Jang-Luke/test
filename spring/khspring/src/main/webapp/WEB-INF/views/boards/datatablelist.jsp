<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>
  <link href="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.13.4/datatables.min.css" rel="stylesheet"/>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.13.4/datatables.min.js"></script>
  <style>
    td {
        border-bottom: 1px solid #00000030;
    }
    #myTable{
        width: 90vw;
        margin: auto;
    }
    .id{
        width: 10%;
    }
    .writer{
        width: 20%;
    }
    .title{
        width: 35%;
    }
    .view-count{
        width: 10%;
    }
    .like-count{
        width: 10%;
    }
    .formed-write-date{
        width: 15%;
    }
  </style>
</head>
<body>
<table id="myTable">
  <thead>
  <tr>
    <th>no</th>
    <th>writer</th>
    <th>title</th>
    <th>view count</th>
    <th>like count</th>
    <th>write date</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${boards}" var="i">
    <tr>
      <td class="id">${i.id}</td>
      <td class="writer">${i.writer}</td>
      <td class="title">
        <a href="/boards/${i.id}">
            ${i.title}
        </a>
      </td>
      <td class="view-count">${i.viewCount}</td>
      <td class="like-count">${i.likeCount}</td>
      <td class="formed-write-date">${i.formedWriteDate}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="/boards">목록으로</a>
<a href="/">홈으로</a>
<script>
    // let table = new DataTable('#data-list-table');
    $(document).ready(function () {
        $('#myTable').DataTable({
            lengthChange: false,
            ordering: false,
            info: false,
            "paging": true,
            order: [[1, "asc"]],
        });
    });

    $('#next').on('click', function () {
        dataTable.page('next').draw('page');
    });

    $('#previous').on('click', function () {
        dataTable.page('previous').draw('page');
    });
</script>
</body>
</html>
