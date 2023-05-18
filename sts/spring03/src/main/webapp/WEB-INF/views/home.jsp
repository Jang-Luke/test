<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
    .container {
        width: 85vw;
        display: flex;
        border: 1px solid black;
    }
    .left {
        flex: 5 1 0;
        padding-top: 3rem;
        padding-bottom: 3rem;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-content: space-around;
    }
    .right {
        flex: 5 1 0;
        padding-top: 3rem;
        padding-bottom: 3rem;
		display: flex;
        flex-direction: column;
        justify-content: center;
        align-content: space-around;
    }
</style>
</head>
<body>
	<div class="container">
        <div class="left">
            <a href="/message/register">메세지 등록</a>
            <a href="/message/modify">메세지 수정</a>
        </div>
        <div class="right">
            <a href="/message/list">메세지 보기</a>
            <a href="/message/delete">메세지 삭제</a>
        </div>
    </div>
</body>
</html>