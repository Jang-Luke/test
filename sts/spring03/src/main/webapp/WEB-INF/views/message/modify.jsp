<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
<style>
* {
	box-sizing: border-box;
}

.id {
	flex: 2 1 0;
}

.writer {
	flex: 5 1 0;
}

.message {
	flex: 10 1 0;
}

.button {
	flex: 1 1 0;
	max-width: 150px;
}

form {
	display: flex;
	justify-content: space-around;
}

input {
	width: 100%;
	height: 100%; padding : 5px 3px 5px 3px;
	text-indent: 5px;
	min-height: 25px;
	padding: 5px 3px 5px 3px;
}

input::placeholder {
	color: #b5b5b5;
}

.container-modify {
	width: 85vw;
	margin: auto;
}
</style>
</head>

<body>
	<jsp:include page="/WEB-INF/views/message/list_component.jsp" />
	<div class="container-modify">
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

    <script>
		const content = document.querySelectorAll('.content');
        const inputId = document.querySelector('#id');
        const inputWriter = document.querySelector('#writer');
        const inputMessage = document.querySelector('#message');
        content.forEach(function(e) {
            e.addEventListener('click', function() {
                inputId.value = this.children[0].children[0].textContent;
                inputWriter.value = this.children[1].children[0].textContent;
                inputMessage.value = this.children[2].children[0].textContent;
            })
        });
    </script>
</body>

</html>