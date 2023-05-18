<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Register</title>
    <style>
        .container {
            width: 85vw;
            margin: auto;
        }

        .writer {
            flex: 4 1 0;
        }

        .message {
            flex: 10 1 0;
        }
        .button {
            flex: 2 1 0;
        }
        form {
            display: flex;
            justify-content: space-around;
        }
        input {
            width: 90%;
            padding: 5px 3px 5px 3px;
            text-indent: 5px;
            min-height: 25px;
        }
        input::placeholder {
            color: #b5b5b5;
        }
        
    </style>
</head>

<body>
    <div class="container">
        <form action="/message/register" method="post">
        	<input type="hidden" name="id" value="0" readonly>
            <div class="writer">
                <input type="text" name="writer" id="writer" placeholder="작성자">
            </div>
            <div class="message">
                <input type="text" name="message" id="message" placeholder="메세지 내용">
            </div>
            <div class="button">
                <input type="submit" value="작성">
            </div>
        </form>
    </div>
    <hr>
    <a href="/">Back</a>
</body>

</html>