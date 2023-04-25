<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Uploaded File</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/upload.file" method="post" enctype="multipart/form-data">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h3>File Upload</h3>
            </div>
            <div class="col-12">
                <input type="text" class="form-control" name="message" placeholder="전송할 메세지 입력">
                <input type="file" class="form-control" name="file1"><br>
                <input type="file" class="form-control" name="file2"><br>
                <input type="file" class="form-control" name="file3">
            </div>
            <div class="col-12">
                <button class="btn btn-light">Upload</button>
                <a href="/">
                    <button class="btn btn-dark" type="button">Back</button>
                </a>
            </div>
        </div>
    </div>
</form>
</body>
</html>
