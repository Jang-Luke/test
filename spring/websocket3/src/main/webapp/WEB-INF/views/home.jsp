<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Home</title>
  <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>  <style>
      * {
          box-sizing: border-box;
      }

      .chat-container {
          margin: auto;
          height: 80vh;
      }

      .chat-container > div {
          border: 1px solid black;
      }

      .chat-box {
          height: 80%;
      }

      .chat-input {
          height: 20%;
      }
  </style>
</head>
<body>
<script>
  $(function(){
      const ws = new WebSocket("ws://192.168.160.21//chat");
      ws.
  })
</script>

<div class="chat-container">
  <div class="chat-box">

  </div>
  <div class="chat-input">

  </div>
</div>
</body>
</html>
