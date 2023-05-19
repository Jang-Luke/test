<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
	table {
		border: 1px solid black;
	}
</style>
</head>
<body>
<form action="/login">
	<table>
		<tr>
			<th colspan="2">
				LogIn
			</th>
		</tr>
		<tr>
			<td>
				ID : 
			</td>
			<td>
				<input type="text" name="username" id="username" placeholder="아이디를 입력해주세요.">
			</td>
		</tr>
		<tr>
			<td>
				PW : 
			</td>
			<td>
				<input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요.">
			</td>
		</tr>
	</table>
</form>
</body>
</html>