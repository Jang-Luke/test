<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js'></script>
    <script src='https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js'></script>
    <script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>
    <style>
        .toCenter {
            text-align: center;
            border-radius: 10px;
            background-color: lightgray;
        }

        .toCenter:hover {
            cursor: pointer;
        }

        .disappear {
            display: none;
        }

        .margin-top-1 {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class='container'>
    <div class='row'>
        <div class='col-12 d-flex justify-content-center'>
            <table class='table table-striped'>
                <tr>
                    <th scope='col'>#</th>
                    <th scope='col'>이름</th>
                    <th scope='col'>연락처</th>
                    <th scope='col'>생일</th>
                </tr>
                <C:forEach var="contact" items="${requestScope.contactList}">
                    <tr>
                        <th scope='row'>${contact.id}</th>
                        <td>${contact.name}</td>
                        <td>${contact.contact}</td>
                        <td>${contact.birthday}</td>
                    </tr>
                </C:forEach>
            </table>
        </div>
        <div class='col-12'>
            <p class='toCenter opener'>삭제</p>
            <form class='disappear' action='DeleteServlet' method='post'>
                <label for='deleteId' class='form-label'>번호</label>
                <input name='deleteId' type='text' class='form-control' id='deleteId' placeholder='삭제할 연락처의 번호를 입력하세요.'>
                <button class='btn btn-outline-success margin-top-1'>삭제할래</button>
            </form>
        </div>
        <div class='col-12'>
            <p class='toCenter opener'>수정</p>
            <form class='disappear' action='UpdateServlet' method='post' id='updateCommand'>
                <label for='updateId' class='form-label'>번호</label>
                <input name='updateId' type='text' class='form-control' id='updateId' placeholder='수정할 연락처의 번호를 입력하세요.'>
                <label for='updateName' class='form-label'>이름</label>
                <input name='updateName' type='text' class='form-control' id='updateName' placeholder='이름을 입력하세요.'>
                <label for='updateContact' class='form-label'>연락처</label>
                <input name='updateContact' type='text' class='form-control' id='updateContact' placeholder='연락처를 입력하세요.'>
                <label for='updateBirthday' class='form-label'>생일</label>
                <input name='updateBirthday' type='date' class='form-control' id='updateBirthday' placeholder='생일을 입력하세요.'>
                <button class='btn btn-outline-success margin-top-1'>수정할래</button>
            </form>
        </div>
        <div class='col-12'>
            <button id='returnButton' class='btn btn-outline-primary'>돌아갈래</button>
        </div>
    </div>
</div>
<script>
    const nameRegex = /^[가-힣]+$/;
    const phoneRegex = /^01\d([-\s.\/]?\d{4})([-\s.\/]?\d{4})$/;
    $('#updateCommand').on('submit', function(event) {
        const nameValue = $('#insertName').val();
        const phoneValue = $('#insertContact').val();
        if (nameRegex.test(nameValue) && phoneRegex.test(phoneValue)) {
            return true;
        } else {
            event.preventDefault();
            Swal.fire({
                title: '올바른 값을 입력해주세요',
                icon: 'error',
                showConfirmButton: false,
                timer: 2000,
            });
        }
    });
    document.querySelector('#returnButton').addEventListener('click', ()=>{
            location.href = 'index.html';
        }
    );
    $('.opener').on('click', function() {
        $(this).siblings('form').toggleClass('disappear');
    });
    const now_utc = Date.now();
    const timeOff = new Date().getTimezoneOffset() * 60000;
    const today = new Date(now_utc - timeOff).toISOString().split('T')[0];
    $('#updateBirthday').attr('max', today);
</script>
</body>
</html>
