<%--
  Created by IntelliJ IDEA.
  User: luke
  Date: 2023/04/07
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
    <script src='https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js'></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Main</title>
    <style>
        body{
            background-color: #1BBC9B
        }
        .background-color-green{
            background-color: #a0dbb7
        }
        .border-radius-10{
            border-radius: 10px;
        }

    </style>
</head>
<body>
    <div class="container headContainer background-color-green border-radius-10">
        <div class="row">
            <div class="col-12">
                <span>환영합니다 ${sessionScope.loginKey.name}님 !</span>
                <span>ID : ${sessionScope.loginKey.id}</span>
                <span>PHONE : ${sessionScope.loginKey.phone}</span>
                <span>EMAIL : ${sessionScope.loginKey.email}</span>
                <span>ZIPCODE : ${sessionScope.loginKey.zipcode}</span>
                <span>ADDRESS : ${sessionScope.loginKey.address1} - ${sessionScope.loginKey.address2}</span>
                <span>JOIN_DATE : ${sessionScope.loginKey.join_date}</span>
            </div>
        </div>
    </div>
    <div class="container-fluid bodyContainer">
        <div class="row">
            <div class="col-12">
                <button id="return">돌아가기</button>
            </div>
        </div>
    </div>
    <script>
        document.querySelector('#return').addEventListener('click', () => location.href='/index.jsp');
    </script>
</body>
</html>
