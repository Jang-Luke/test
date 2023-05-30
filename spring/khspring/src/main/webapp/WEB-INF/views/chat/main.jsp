<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Chat</title>
  <script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
  <style>
    * {
      box-sizing: border-box;
      margin: auto;
    }

    .container {
      width: 350px;
      height: 600px;
      border-radius: 15px;
      padding: 10px;
      background-color: #00000030;
    }

    .chat-body {
      width: 100%;
      height: 90%;
      margin-bottom: 5px;
      border-bottom: 1px solid white;
      overflow-y: auto;
    }

    .chat-footer {
      display: flex;
      margin-top: 5px;
      width: 100%;
      height: 10%;
    }

    .chat-line {
      margin: 3px 0px 0px 3px;
      word-break: break-word;
    }

    .sender {
      font-size: 8pt;
      text-indent: 3px;
      text-align: left;
      color: olivedrab;
    }

    .my-id {
      font-size: 8pt;
      text-indent: 3px;
      text-align: right;
      color: olivedrab;
    }

    .content-other {
      display: flex;
      flex-direction: row;
    }

    .content-me {
      display: flex;
      flex-direction: row-reverse;
    }

    .me {
      max-width: 200px;
      padding: 6px;
      background-color: ghostwhite;
      border-top-left-radius: 10px;
      border-top-right-radius: 10px;
      border-bottom-left-radius: 10px;
      margin: 0px;
    }

    .other {
      max-width: 200px;
      padding: 6px;
      background-color: blanchedalmond;
      border-top-left-radius: 10px;
      border-top-right-radius: 10px;
      border-bottom-right-radius: 10px;
      margin: 0px;
    }

    #message {
      flex: 8 0 0;
      height: 100%;
      background-color: white;
      padding: 3px;
      border: none;
      outline: none;
      word-break: break-word;
      overflow: auto;
      border-top-left-radius: 15px;
      border-bottom-left-radius: 15px;
    }

    #message::-webkit-scrollbar {
      display: none;
    }

    #send {
      flex: 2 0 0;
      height: 100%;
      border: none;
      outline: none;
      border-top-right-radius: 15px;
      border-bottom-right-radius: 15px;
    }
  </style>
  <script type="text/javascript">
    $(function () {
      const ws = new WebSocket("ws://192.168.160.21:8080/chat");
      const body = $(".chat-body");
      const msg = $("#message");
      const btn = $("#send");

      msg.on("keydown", function (e) {
        if (e.key == "Enter") {
          e.preventDefault();
        }
        ;
      });
      msg.on("keyup", function (e) {
        if (e.key == "Enter") {
          e.preventDefault();
          if (msg.text() != '') {
            let message = msg.text();
            ws.send(message);
            msg.text('');
            const sender = $("<div>").addClass("my-id").append("${loginId}");
            const text = $("<div>").addClass("content-me").append($("<div>").addClass("me").append(message));
            $("<div>").addClass("chat-line").append(sender, text).appendTo(body);
            body.scrollTop(body.prop("scrollHeight"));
          }
          ;
        }
        ;
      });
      btn.on("click", function () {
        if (msg.text() != '') {
          let message = msg.text();
          ws.send(message);
          msg.text('');
          const sender = $("<div>").addClass("my-id").append(${loginId});
          const text = $("<div>").addClass("content-me").append($("<div>").addClass("me").append(message));
          $("<div>").addClass("chat-line").append(sender, text).appendTo(body);
          body.scrollTop(body.prop("scrollHeight"));
        }
        ;
      });

      ws.onmessage = function (e) {
        let data = JSON.parse(e.data);
        if (!Array.isArray(data)) {
          data = [data];
        }
        data.forEach((e, i) => {
          if (e.sender == "${loginId}") {
            const sender = $("<div>").addClass("my-id").append(e.sender);
            const text = $("<div>").addClass("content-me").append($("<div>").addClass("me").append(e.message));
            $("<div>").addClass("chat-line").append(sender, text).appendTo(body);
          } else {
            const sender = $("<div>").addClass("sender").append(e.sender);
            const text = $("<div>").addClass("content-other").append($("<div>").addClass("other").append(e.message));
            $("<div>").addClass("chat-line").append(sender, text).appendTo(body);
          }
        });

        body.scrollTop(body.prop("scrollHeight"));
      }

    });
  </script>
</head>
<body>

<div class="container">
  <div class="chat-body">

  </div>
  <div class="chat-footer">
    <div id="message" contenteditable="true"></div>
    <%--      <input type="text" name="message" id="message">--%>
    <input type="submit" id="send" value="전송">
  </div>
</div>

</body>
</html>
