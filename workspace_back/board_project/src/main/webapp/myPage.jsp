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
</head>
<body>
    <div class="container headContainer">
        <div class="row">
            <div class="col-12">
                <p>환영합니다 ${sessionScope.loginKey.name}님 !</p>
                <p>ID : ${sessionScope.loginKey.id}</p>
                <p>PHONE : ${sessionScope.loginKey.phone}</p>
                <p>EMAIL : ${sessionScope.loginKey.email}</p>
                <p>ZIPCODE : ${sessionScope.loginKey.zipcode}</p>
                <p>ADDRESS : ${sessionScope.loginKey.address1} - ${sessionScope.loginKey.address2}</p>
                <p>JOIN_DATE : ${sessionScope.loginKey.join_date}</p>
            </div>
        </div>
    </div>
    <div class="container-fluid bodyContainer">
        <div class="row">
            <div class="col-12">

            </div>
        </div>
    </div>
</body>
</html>
