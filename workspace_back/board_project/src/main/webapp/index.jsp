<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
    <style>
        @import
        url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap')
        ;

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }

        body {
            background-color: #1BBC9B;
        }

        div {
            margin: auto;
            width: 300px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }

        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }

        .in {
            margin-bottom: 10px;
        }

        .btn {
            background-color: #1BBC9B;
            margin-bottom: 30px;
            color: white;
        }

        a {
            text-decoration: none;
            color: #9B9B9B;
            font-size: 12px;
        }
    </style>
</head>

<body>




<div>
    <form action="/TryLogin" method="post">
        <input type="text" name="mainId" placeholder="아이디" class="in">
        <input type="password" name="mainPw" placeholder="비밀번호" class="in">
        <input type="submit" class="btn" id="btn" value="로그인"><br>
        <input type="button" class="btn" id="toJoin" value="회원가입"><br>
        <input type="checkbox" name="" id="">ID 기억하기
    </form>
    <a href="#none">비밀번호를 잊어버리셨나요?</a>
</div>
<script>
    $('#toJoin').on('click', function() {
        location.href="/member/joinform.jsp";
    })
</script>
</body>
</html>