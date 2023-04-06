<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
    <script src='https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js'></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <base href="resonable">
    <style>
        * {
            padding: 0px;
        }

        .inputBox {
            width: 100%;
            height: 100%;
            padding: 5px;
        }

        .text-align-center {
            text-align: center;
        }

        .font-size-sm {
            font-size: 10pt;
            text-align: right;
            padding: 5px;
        }

        .validate {
            color: #87ceeb;
        }
    </style>
</head>

<body>
<form action="/Join" id="frm" method="post">
    <div class="container">
        <div class="row">
            <div class="col-12 text-align-center">
                회원가입 정보
            </div>
        </div>
        <div class="row">
            <div class="col-3 col-sm-2 col-md-2 font-size-sm">
                아이디
            </div>
            <div class="col-9 col-sm-7 col-md-6 p-1">
                <input type="text" name="inId" class=" form-control enterToNext" id="inId" placeholder="아이디를 입력해주세요.">
            </div>
            <div class="col-12 col-sm-3 col-md-4 d-flex justify-content-sm-left align-items-center justify-content-center">
                <button type="button" id="duplicationCheck" class="btn btn-outline-primary">중복확인</button>
            </div>
        </div>
        <div class="row">
            <div class="col-3 col-sm-2 col-md-2 font-size-sm">
                패스워드
            </div>
            <div class="col-9 col-sm-7 col-md-6 p-1">
                <input type="password" name="inPw" class=" form-control enterToNext" id="inPw" placeholder="패스워드를 입력해주세요.">
            </div>
            <div class="col-12 col-sm-3 col-md-4 d-flex justify-content-sm-left align-items-center justify-content-center">
            </div>
        </div>
        <div class="row">
            <div class="col-3 col-sm-2 col-md-2 font-size-sm">
                패스워드 확인
            </div>
            <div class="col-9 col-sm-7 col-md-6 p-1">
                <input type="password" class=" form-control enterToNext" id="inPw2" placeholder="패스워드를 다시 입력해주세요.">
            </div>
            <div class="col-12 col-sm-3 col-md-4 d-flex justify-content-sm-left align-items-center justify-content-center">
                <p id="validatePW"></p>
            </div>
        </div>
        <div class="row">
            <div class="col-3 col-sm-2 col-md-2 font-size-sm">
                이름
            </div>
            <div class="col-9 col-sm-7 col-md-6 p-1">
                <input type="text" name="inName" class=" form-control enterToNext" id="inName" placeholder="이름 입력해주세요.">
            </div>
            <div class="col-12 col-sm-3 col-md-4">
            </div>
        </div>
        <div class="row">
            <div class="col-3 col-sm-2 col-md-2 font-size-sm">
                전화번호
            </div>
            <div class="col-9 col-sm-7 col-md-6 p-1">
                <input type="text" name="inPhone" class=" form-control enterToNext" id="inPhone" placeholder="전화번호를 입력해주세요.">
            </div>
            <div class="col-12 col-sm-3 col-md-4">
            </div>
        </div>
        <div class="row">
            <div class="col-3 col-sm-2 col-md-2 font-size-sm">
                이메일
            </div>
            <div class="col-9 col-sm-7 col-md-6 p-1">
                <input type="text" name="inEmail" class=" form-control enterToNext" id="inEmail" placeholder="이메일을 입력해주세요.">
            </div>
            <div class="col-12 col-sm-3 col-md-4">
            </div>
        </div>
        <div class="row">
            <div class="col-3 col-sm-2 col-md-2 font-size-sm">
                우편번호
            </div>
            <div class="col-9 col-sm-7 col-md-6 p-1">
                <input type="text" name="inZipcode" class=" form-control enterToNext" id="inZipcode" readonly>
            </div>
            <div class="col-12 col-sm-3 col-md-4 d-flex justify-content-sm-left align-items-center justify-content-center">
                <button type="button" class="btn btn-outline-primary">찾기</button>
            </div>
        </div>
        <div class="row">
            <div class="col-3 col-sm-2 col-md-2 font-size-sm">
                주소1
            </div>
            <div class="col-9 col-sm-10 col-md-10 p-1">
                <input type="text" name="inAddress1" class=" form-control enterToNext" id="inAddress1" readonly>
            </div>
        </div>
        <div class="row">
            <div class="col-3 col-sm-2 col-md-2 font-size-sm">
                주소2
            </div>
            <div class="col-9 col-sm-10 col-md-10 p-1">
                <input type="text" name="inAddress2" class=" form-control enterToNext" id="inAddress2">
            </div>
        </div>
        <div class="row">
            <div class="col-12 d-flex justify-content-center">
                <button type="button" class="btn btn-outline-primary m-1" id="submitBtn">회원 가입</button>
                <button class="btn btn-outline-danger m-1" type="reset">다시 입력</button>
            </div>
        </div>
    </div>
</form>

<script>
    const idRegex = /^[a-z0-9_]{6,14}$/;
    const pwRegex = /.{6,12}/;
    const nameRegex = /^[가-힣]+$/;
    const phoneRegex = /^01\d([-\s.\/]?\d{4})([-\s.\/]?\d{4})$/;
    const emailRegex = /\w{4,16}@\w+\.com$/;
    const pw1 = document.querySelector('#inPw');
    const pw2 = document.querySelector('#inPw2');
    let checkIdValidation = () => {
        const id = document.querySelector('#inId').value;
        return idRegex.test(id);
    }
    let checkPwValidation = () => {
        const pw1Value = document.querySelector('#inPw').value;
        const pw2Value = document.querySelector('#inPw2').value;
        const result = document.querySelector('#validatePW');
        if (pw1Value == pw2Value && pw1Value != '' && pw2Value != '') {
            result.innerText = '비밀번호가 일치합니다.';
            result.className = 'validate';
            return true;
        } else if (pw1Value == '' || pw2Value == '') {
            result.innerText = '';
            result.className = '';
        } else {
            result.innerText = '패스워드가 일치하지 않습니다.';
            result.className = '';
        }
    }
    let checkNameValidation = () => {
        const name = document.querySelector('#inName').value;
        return nameRegex.test(name);
    }
    let checkPhoneValidation = () => {
        const phone = document.querySelector('#inPhone').value;
        return phoneRegex.test(phone);
    }
    let checkEmailValidation = () => {
        const email = document.querySelector('#inEmail').value;
        return emailRegex.test(email);
    }
    let showAlert = (bool) => {
        if (bool) {
            Swal.fire({
                icon: 'success',
                title: '가입 성공!',
                text: '메인 페이지로 이동하여 로그인하세요.',
            }).then((result) => {
                if (result.isConfirmed) {
                    $('#submitBtn').closest('form').submit();
                }
            });
        } else {
            Swal.fire({
                icon: 'error',
                title: '가입 실패',
                text: '입력하신 내용을 다시 확인하세요.',
            })
        }
    }
    $('#inId').on('keyup', function (event) {
        const target = $('#duplicationCheck');
        if (target.hasClass('btn-black') && event.key !== 'Enter') {
            target.removeClass('btn-black');
            target.addClass('btn-outline-primary');
            target.text('중복확인');
            target.prop('disabled', false);
        }
    })
    $('#duplicationCheck').on('click', function() {
        if (checkIdValidation()) {
            window.open("/IdCheck?inId="+$('#inId').val(), "", "width=350px,height=250px");
        } else{
            Swal.fire({
                title: '아이디를 다시 확인해주세요.',
                icon: 'error',
                showConfirmButton: false,
                timer: 1000,
            });
        }
    })

    $('#submitBtn').on('click', function() {
        const result = checkIdValidation() && checkPwValidation() && checkNameValidation() && checkPhoneValidation() && checkEmailValidation();
        const is_id_validate = $('#duplicationCheck').hasClass('btn-black');
        if (result && is_id_validate) {
            showAlert(result);
        } else if(result && !is_id_validate) {
            Swal.fire({
                title: '아이디 중복 여부를 확인해주세요.',
                icon: 'question',
                showConfirmButton: false,
                timer: 1000
            })
        } else{
            showAlert(result);
        }
    })
    pw1.addEventListener('keyup', checkPwValidation);
    pw2.addEventListener('keyup', checkPwValidation);
    $('.enterToNext').on('keyup', function(event) {
        if (event.key=='Enter') {
            event.preventDefault();
            $(this).closest('.row').next().find('.enterToNext').focus();
        }
    })
</script>
</body>

</html>