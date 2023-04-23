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
    <script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <C:forEach items="${requestScope.fileList}" var="file" varStatus="status">
            <div class="col-12">
                <img src="/upload/${file.systemName}" alt="${file.systemName}">
                <a href="/download.file?systemName=${file.systemName}&originalName=${file.originalName}">${file.originalName}</a>
            </div>
        </C:forEach>
    </div>
    <div class="row">
        <div class="col-12">
            <span id="result"></span>
        </div>
    </div>
</div>
<script>
    $('a').on('click', function(event){
        const systemName = $(this).siblings('img').attr('alt');
        const originalName = $(this).text();
        $.ajax({
            url: "/download.file",
            method: "GET",
            data: {
                systemName: systemName,
                originalName: originalName
            },
            xhr: function () {
                let xhr = new XMLHttpRequest();
                xhr.responseType = "blob";
                return xhr;
            },
        }).done(function(data, message, xhr){
            if (xhr.readyState === 4 && xhr.status === 200) {
                const fileName = originalName;
                const blob = new Blob([data]);
                const doDownload = $('<a>');
                doDownload.attr('href', window.URL.createObjectURL(blob));
                doDownload.download = fileName;
                doDownload.click();
                $('#result').append(doDownload);
                alert("성공?");
            } else {
                alert("다운로드에 실패했습니다.");
            }
        }).fail(() => alert("실패?"));
    })
</script>
</body>
</html>
