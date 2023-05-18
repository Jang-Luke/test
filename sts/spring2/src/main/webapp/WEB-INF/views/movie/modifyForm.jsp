<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Form</title>
</head>
<body>
	<form action="/movie/modify" method="post">
		<table>
			<tr>
				<th colspan="3">수정하기</th>
			</tr>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Genre</td>
			</tr>
			<tr>
				<td><input type="text" name="id" placeholder="수정할 아이디"></td>
				<td><input type="text" name="title" placeholder="수정할 제목"></td>
				<td><input type="text" name="genre" placeholder="수정할 장르"></td>
			</tr>
		</table>
		<input type="submit" value="제출">
	</form>
</body>
</html>