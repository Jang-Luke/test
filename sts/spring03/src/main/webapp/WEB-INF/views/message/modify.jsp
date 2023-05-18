<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Modify</title>
    <style>
        .container {
            width: 85vw;
            margin: auto;
        }

        .id {
            flex: 3 1 0;
        }

        .writer {
            flex: 4 1 0;
        }

        .message {
            flex: 8 1 0;
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
	<jsp:include page="/WEB-INF/views/message/list_component.jsp"/>
    <div class="container">
        <form action="/message/modify" method="post">
            <div class="id">
                <input type="text" name="id" id="id" placeholder="글 번호">
            </div>
            <div class="writer">
                <input type="text" name="writer" id="writer" placeholder="작성자">
            </div>
            <div class="message">
                <input type="text" name="message" id="message" placeholder="메세지 내용">
            </div>
            <div class="button">
                <input type="submit" value="수정">
            </div>
        </form>
    </div>
    <hr>
    <a href="/">Back</a>
</body>

</html>