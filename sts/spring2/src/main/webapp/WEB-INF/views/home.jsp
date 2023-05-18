<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<p>Hello, Spring
	<form action="/" method="post">
		<input type="text" name="param">
	</form>
	<table>
		<tr>
			<th colspan=4>Index</th>
		</tr>
		<tr>
			<td>
				<a href="/to/input">toInput</a>
			</td>
			<td>
				<a href="/movie/list">Show Movie List</a>
			</td>
			<td>
				<a href="/movie/delete">Delete movie</a>
			</td>
			<td>
				<a href="/movie/modify">Modify movie</a>
			</td>
		</tr>
	</table>
</body>
</html>