<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
* {
	box-sizing: border-box;
}

.container {
	width: 85vw;
	margin: auto;
	display: flex;
	justify-content: space-around;
}

.header {
	border: 1px solid black;
}

.row {
	text-align: center;
	font-weight: bold;
	font-size: 12pt;
}

.content-text {
	text-align: center;
	font-size: 10pt;
}

.id {
	flex: 3 1 0;
}

.writer {
	flex: 6 1 0;
}

.message {
	flex: 10 1 0;
}
</style>
<div class="container header">
	<div class="id">
		<p class="row">글 번호</p>
	</div>
	<div class="writer">
		<p class="row">작성자</p>
	</div>
	<div class="message">
		<p class="row">메세지 내용</p>
	</div>
</div>
<c:forEach var="message" items="${list}">
	<div class="container content">
		<div class="id">
			<p class="content-text">${message.id}</p>
		</div>
		<div class="writer">
			<p class="content-text">${message.writer}</p>
		</div>
		<div class="message">
			<p class="content-text">${message.message}</p>
		</div>
	</div>
</c:forEach>