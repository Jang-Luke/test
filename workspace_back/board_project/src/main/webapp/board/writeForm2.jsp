<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <link href="../summernote-0/summernote.css" rel="stylesheet"/>
    <script src="../summernote-0/summernote.js"></script>
    <script src="lang/summernote-ko-KR.js"></script>
    <title>Document</title>
    <style>
        .hidden {
            display: none;
        }

        .border-solid-1 {
            border: 1px solid black;
        }

        .codex-editor__redactor {
            padding-bottom: 50px !important;
        }
    </style>
</head>
<body>
<form action="/insert.board" method="post">

    <div class="container border-solid-1">
        <div class="row">
            <div class="col-12 border-solid-1">
                <p class="font-size-title">게시글 작성하기</p>
            </div>
            <div class="col-12 border-solid-1">
                <input type="text" name="inWriter" id="inWriter" class="hidden" value="${sessionScope.loginKey.id}">
                <input type="text" name="inTitle" id="inTitle" class="form-control" placeholder="글 제목을 입력하세요">
                <%--            <input type="text" name="inContents" id="inContents" class="hidden">--%>
            </div>
        </div>
        <div class="row boardbody">
            <div class="col-12">
                <textarea name="inContents" id="summernote"></textarea>
            </div>
        </div>
        <%--        <div class="row">--%>
        <%--            <div class="col-12 board-content-body word-break-all" id="content">${requestScope.targetContent.contents}</div>--%>
        <%--        </div>--%>
        <div class="row boardFooter">
            <div class="col-12 d-flex justify-content-end border-solid-1">
                <a href="/select.board?currentPage=1">
                    <button>목록으로</button>
                </a>
                <button id="doWrite">작성완료</button>
            </div>
        </div>
    </div>
</form>
<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            toolbar: [
                // [groupName, [list of button]]
                ['style', ['bold', 'italic', 'underline', 'clear']],
                ['font', ['strikethrough', 'superscript', 'subscript']],
                ['fontsize', ['fontsize']],
                ['color', ['color']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['height', ['height']]
            ],
            lang: 'ko-KR', // default: 'en-US'
            height: 300,
            minHeight: 150,
            maxHeight: 600,
            focus: true,
        });
    });
    var markupStr = $('#summernote').summernote('code');
    var markupStr = 'hello world';
    $('#summernote').summernote('code', markupStr);
    const inContents = document.querySelector('#inContents');
    $('#doWrite').on('click', function () {
        $(this).closest('form').submit();
    });

</script>
</body>
</html>
