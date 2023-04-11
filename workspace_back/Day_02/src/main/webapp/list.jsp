<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <style>
        .inputBar {
            display: flex;
            flex-flow: column wrap;
            justify-content: center;
            background-color: lightgray;
        }

        p {
            margin-top: 5px;
            margin-bottom: 5px;
        }

        label {
            display: inline-block;
            width: 60px;
        }

        .formFlex {
            display: flex;
            flex-flow: row wrap;
            justify-content: center;
            margin: 10px;
        }

        input[type='text'] {
            width: 200px;
            padding: 2px;
            margin: 3px;
        }

        form {
            border-top: 1px solid gray;
            border-bottom: 1px solid gray;
            margin-bottom: 0px;
        }
    </style>
    <script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>
</head>
<!-- 표현언어의 키 값으로 한글 불가 -->
<!-- HTML 주석 안에서 표현 언어 사용하면 분석은 되지만 출력은 안됨. -->
<%--EL : Expression Language<br>--%>
<%--Controller 로 부터 넘어온 숫자 값 : ${number + 50} : ${number == 100}<br>--%>
<%--Controller 로 부터 넘어온 문자 값 : ${string}<br>--%>
<%--Controller 로 부터 넘어온 배열 값 : ${arr[0]} : ${arr[1]} : ${arr[2]} : ${arr[4]}<br>--%>
<%--Controller 로 부터 넘어온 DTO 값 : ${dto.id} : ${dto.writer} : ${dto.message}<br>--%>
<%--Controller 로 부터 넘어온 List<DTO> : list의 사이즈 ${messageList.size()}<br>--%>
<%--${messageList[0].id} : ${messageList[0].writer} : ${messageList[0].message}<br>--%>
<%--${messageList[1].id} : ${messageList[1].writer} : ${messageList[1].message}<br>--%>
<%--..--%>
<%--..--%>
<%--<br><hr>--%>
<%--JSTL : JSP Standard Tag Library--%>
<%--<C:if test="number == 100">--%>
<%--    number 안에 있는 값은 100 입니다!--%>
<%--</C:if>--%>
<%--<C:choose>--%>
<%--    <C:when test="${string.equals('Hello JSP')}">--%>
<%--        문자열 안에 담겨있는 값은 Hello JSP--%>
<%--    </C:when>--%>
<%--    <C:when test="${string.equals('Hello JSTL')}">--%>
<%--        문자열 안에 담겨있는 값은 Hello JSTL--%>
<%--    </C:when>--%>
<%--    <C:otherwise>--%>
<%--        문자열 안에는 JSP도 JSTL도 아닌 값이 저장되어 있음--%>
<%--    </C:otherwise>--%>
<%--</C:choose>--%>
<body>
<table border='1' align='center'>
    <tr>
        <th>글번호</th>
        <th>작성자</th>
        <th>메세지</th>
    </tr>
    <C:forEach var="message" items="${requestScope.messageList}">
        <tr>
            <td>${message.id}</td>
            <td>${message.writer}</td>
            <td>${message.message}</td>
        </tr>
    </C:forEach>
    <tr>
        <th colspan="3"><button id='toIndex'>돌아가기</button></th>
    </tr>
</table>
<br>
<div class='inputBar'>
    <form action='insert.message' method='post' class='formSubmit'>
        <div class='formFlex'>
            <label for='writer'>작성자</label>
            <input type='text' name='writer' id='writer' placeholder='작성자를 입력하세요.'>
        </div>
        <div class='formFlex'>
            <label for='insertMessage'>내용</label>
            <input type='text' name='message' id='insertMessage' placeholder='메세지를 입력하세요.'>
        </div>
        <div class='formFlex'>
            <input type='button' value='메세지 입력할래'>
        </div>
    </form>
    <form action='delete.message' method='post' class='formSubmit'>
        <div class='formFlex'>
            <label for='deleteId'>글번호</label>
            <input type='text' name='id' id='deleteId' placeholder='삭제할 글번호를 입력하세요.'>
        </div>
        <div class='formFlex'>
            <input type='button' value='메세지 삭제할래'>
        </div>
    </form>
    <form action='update.message' method='post' class='formSubmit'>
        <div class='formFlex'>
            <label for='modifyId'>글번호</label>
            <input type='text' name='id' id='modifyId' placeholder='글번호를 입력하세요.'>
        </div>
        <div class='formFlex'>
            <label for='modifyMessage'>내용</label>
            <input type='text' name='message' id='modifyMessage' placeholder='수정할 메세지를 입력하세요.'>
        </div>
        <div class='formFlex'>
            <input type='button' value='메세지 수정할래'>
        </div>
    </form>
</div>
<script>
    const showAlert = function() {
        Swal.fire({
            title: '진짜?',
            showDenyButton: true,
            confirmButtonText: '네!',
            denyButtonText: '아니요..',
        }).then((result)=>{
                if (result.isConfirmed) {
                    this.closest('form').submit();
                } else if (result.isDenied) {
                    return false;
                }
            }
        )
    };
    const forms = document.querySelectorAll('input[type=button]');
    Array.from(forms).forEach((element)=>element.addEventListener('click', showAlert));
    const inputs = document.querySelectorAll('input[type=text]');
    Array.from(inputs).forEach((element)=>element.addEventListener('keyup', function(e) {
        if (e.key == 'Enter') {
            showAlert();
        }
    }));
    document.querySelector('#toIndex').addEventListener('click', ()=>{
            location.href = 'index.html'
        }
    )
</script>
</body>
</html>
