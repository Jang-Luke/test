<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
<style>
	form {
		width: 85vw;
		display: flex;
		margin: auto;
	}
	.delete-input {
		flex: 8 1 0;
	}
	.delete-button {
		flex: 2 1 0;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/message/list_component.jsp"/>
	<form action="/message/delete" method="post">
		<input class="delete-input" type="text" name="id" placeholder="삭제할 아이디 입력">
		<input class="delete-button" type="submit" value="삭제">
	</form>
	<hr>
	<a href="/">Back</a>
</body>
</html>