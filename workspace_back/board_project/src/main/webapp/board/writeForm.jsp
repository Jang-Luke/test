<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
        .hidden{
            display: none;
        }
    </style>
</head>
<body>
<form action="/insert.board" method="post">
    <table border="1">
        <tr>
            <th width="540">자유게시판 글 작성하기</th>
        </tr>
        <tr>
            <td width="540">
                <select>
                    <option>뉴스</option>
                    <option>유머</option>
                    <option>잡담</option>
                </select>
                <input type="text" name="inWriter" id="inWriter" class="hidden" value="${sessionScope.loginKey.id}">
                <input type="text" name="inTitle" placeholder="글 제목을 입력하세요" style="width:476px">
            </td>
        </tr>
        <tr>
            <td>
                <textarea name="inContents" placeholder="글 내용을 입력하세요" cols="74" rows="15"></textarea>
            </td>
        </tr>
        <tr>
            <td align="right">
                <a href="/board/board_main.jsp">
                    <button>목록으로</button>
                </a>
                <button id="doWrite">작성완료</button>
            </td>
        </tr>
    </table>
</form>
<script>
    $('#doWrite').on('click', function(){
        $(this).closest('form').submit();
    });
</script>
</body>
</html>
