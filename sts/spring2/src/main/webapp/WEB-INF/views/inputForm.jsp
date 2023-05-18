<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Input Form Here</h2>
	<form action="/movie/register" method="post">
		<table>
			<tr>
				<td>
					<label for="title">
						title : 
					</label>
				</td>
				<td>
					<input type="text" name="title" id="title" placeholder="영화 제목">
				</td>
			</tr>
			<tr>
				<td>
					<label for="genre">
						genre : 
					</label>
				</td>
				<td>
					<input type="text" name="genre" id="genre" placeholder="영화 장르">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="확인">
				</td>
			</tr>
			<tr>
				<td>
					<a href="/">Back</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>