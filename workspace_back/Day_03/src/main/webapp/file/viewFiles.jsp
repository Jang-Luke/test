<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>View Files</title>
    <style>
        img {
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <C:forEach items="${requestScope.fileList}" var="file" varStatus="status">
            <div class="col-12">
                <img src="/upload/${file.systemName}">
            </div>
        </C:forEach>
    </div>
</div>
</body>
</html>
