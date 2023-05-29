<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <link href="webjars/jQuery/dist/jquery.js">
</head>
<body>
<c:choose>
  <c:when test="${sessionScope.loginId != null}">
    <p>= ${sessionScope.loginId} = 님 환영합니다.</p>
    <hr>
    <a href="/boards">게시판으로</a>
    <br>
    <a href="/boards/register">작성하기</a>
    <br>
    <a href="/members/logout">로그아웃</a>
  </c:when>
  <c:otherwise>
    <form action="/members/login" method="post">
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
        <tr>
          <td colspan="2" align="center">
            <button type="submit">로그인</button>
            <a href="/members/signup">
              <button type="button">회원가입</button>
            </a>
            <br>
            ID 기억하기<input type="checkbox" name="rememberUsername" id="usernameCheck" value="on">
            <input type="hidden" name="_rememberUsername" id="_usernameCheck" value="on">
          </td>
        </tr>
      </table>
    </form>
    <script>
        function getCookie(cookieName) {
            let cookieData = document.cookie;
            cookieData.split(';')
                .filter((c) => c.startsWith(cookieName));
            if (cookieData.length > 0) {
                let cookieValue = cookieData[0].split('=')[1];
                return cookieValue;
            } else {
                return '';
            }
        }
        document.addEventListener('DOMContentLoaded', function() {
            const rememberUsername = getCookie('rememberUsername');
            const inputUsername = document.querySelector('#username');
            const checkUsername = document.querySelector('#usernameCheck')
            inputUsername.value = rememberUsername;
            if (inputUsername.value != '') {
                checkUsername.setAttribute('checked', true);
            }
        })
    </script>
  </c:otherwise>
</c:choose>
<br><br><br>
<hr>
<a href="/mybatis">to mybatis</a>
</body>
</html>