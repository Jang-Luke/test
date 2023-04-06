<%--
  Created by IntelliJ IDEA.
  User: luke
  Date: 2023/04/06
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head><title>index</title>
</head>
<body>
<table border="1" align="center">
    <tr>
        <th colspan="2">Login Box</th>
    </tr>
    <tr>
        <td>
            아이디 :
        </td>
        <td>
            <input type="text" placeholder="Input your id">
        </td>
    </tr>
    <tr>
        <td>
            패스워드 :
        </td>
        <td>
            <input type="text" placeholder="Input your pw">
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <a href="quiz04_boardList.html"><input type="button" value="로그인"></a>
            <input type="button" value="회원가입"><br>
            <input type="checkbox">ID 기억하기
        </td>
    </tr>
</table>
</body>
</html>
