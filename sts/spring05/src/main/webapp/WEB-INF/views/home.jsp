<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
</head>
<style>
   div{
      border: 1px solid black;
      box-sizing: border-box;
      margin: auto;
   }
   .contents{
      width: 300px;
   }
   .body{
      height: 400px;
   }
   
   .footer>input{
      height: 50px;
      border: none;
      out-line:none;
      padding: 0px;
   }
   .footer{
   		display: flex;
   		justify-content: center;
   }
   #chat{
   		flex: 8 0 0;   
   }
   #send{
   		flex: 2 0 0;
   }
</style>
<body>
   <script type="text/javascript">
      $(function(){
         const ws = new WebSocket("ws://192.168.50.25/chat");
         
         $("#chat").on("keyup", function(e){
        	 if (e.key == "Enter") {
        		const message = $("#chat").val();
				ws.send(message);
				$("#chat").val("");
				$("#chat").focus();
			}
         });
         
         $("#send").on("click", function() {
        	 const message = $("#chat").val();
        	 ws.send(message);
        	 $("#chat").val("");
			 $("#chat").focus();
         });
         ws.onmessage = function(e) {
        	 console.log(e.data);
         }
      });
   </script>

   <div class="contents">
      <div class="body"></div>
      <div class="footer">
         <input type="text" id="chat">
         <input type="button" id="send" value="전송">
      </div>
   </div>
</body>
</html>