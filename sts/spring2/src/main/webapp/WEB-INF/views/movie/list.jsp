<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>
</head>
<body>
	<c:forEach var="movie" items="${movies}">
		${movie.id} : ${movie.title} : ${movie.genre}<br>
	</c:forEach>
</body>
</html>