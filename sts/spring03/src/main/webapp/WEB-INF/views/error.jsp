<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error!</title>
<style>
	.strong-message {
		font-weight: bold;
		font-size: 18px;
		color: red;
	}
	.container {
		display: flex;
		width: 70vw;
		margin: auto;
	}
</style>
</head>
<body>
	<div class="container error-page">
		<p class="strong-message">${exceptionType}</p>
		<p class="strong-message">${message}</p>
		<br>
		<a href="/">Back</a>
	</div>
</body>
</html>