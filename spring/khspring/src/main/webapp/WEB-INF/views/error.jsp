<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Error!</title>
</head>
<body>
<h1>${exceptionType}!</h1>
<hr>
<h2>${exceptionCause}</h2>
</body>
</html>
