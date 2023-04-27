<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8' %>
<%@ taglib prefix='C' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page isELIgnored='false' %>
<html>
<head>
  <title>Title</title>
  <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>

  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js'></script>
  <script src='https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js'></script>
</head>
<body>
<div class='container-fluid'>
  <div class='row'>
    <div class='col-12'>
      <fieldset>
        <legend>기본 AJAX</legend>
        <button id='ajax1'>테스트</button>
        <button id='ajax2'>테스트</button>
        <button id='ajax3'>테스트</button>
        <button id='ajax4'>테스트</button>
        <button id='ajax5'>테스트</button>
        <br>
        <hr>
        <input type="file" name="file">
        <button id='ajax6'>테스트</button>
      </fieldset>
    </div>
  </div>
</div>
<script>
    document.querySelector('#ajax1').addEventListener('click', function () {
        fetch('/exam01.fetch', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify({
                title: 'test',
                body: 'I am testing!',
                userId: 1
            })
        }).then((response) => response.json())
            .then((data) => console.log(data))
    });
    document.querySelector('#ajax2').addEventListener('click', function () {
        fetch('/exam02.fetch', {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-type': 'application/json'
            },
            body: JSON.stringify({
                title: 'exam02 테스트',
                myName: '내 이름?'
            })
        }).then((response) => {
            console.log(response);
            return response.json();
        })
            .then((data) => console.log(data));
    });
    $('#ajax3').on('click', function () {
        $.ajax({
            url: "/exam03.fetch",
            method: "POST",
            data: {
                id: "113",
                name: "GilUng",
                contact: "secrete"
            },
            dataType: "json"
        }).done((result) => {
            console.log(result);
            console.log(result.name);
        });
    });
    $('#ajax4').on('click', function () {
        $.ajax({
            url: "/exam04.fetch",
            dataType: "json"
        }).done((result) => console.log(result));
    });
    $('#ajax5').on('click', function () {
        $.ajax({
            url: "/exam05.fetch",
            dataType: "json"
        }).done((result) => {
            console.log(result);
        });
    });
    $('#ajax6').on('click', function () {
        const fileInput = $('input[type=file]')[0];
        const file = fileInput.files[0];
        if (!file) {
            alert('파일을 먼저 선택해야 합니다.');
            return;
        }
        let formData = new FormData();
        formData.append("file", file);
        $.ajax({
            url: "/exam06.fetch",
            type: "POST",
            data: formData,
            processData: false,
            contentType: false,
        });
    });
</script>
</body>
</html>
