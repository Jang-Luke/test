<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>What do you want to delete?</title>
<script
	  src="https://code.jquery.com/jquery-3.7.0.min.js"
	  integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	  crossorigin="anonymous"></script>
</head>
<body>
	<table>
		<tr>
			<th colspan="2">삭제할 아이디를 입력하세요.</th>
		</tr>
		<tr>
			<td>
				<label for="deleteId">
					Delete ID : 
				</label>
			</td>
			<td>
				<form action="/movie/delete" method="post">
					<input type="text" name="deleteId" placeholder="삭제할 영화 아이디">
					<button type=submit>삭제할래</button>
				</form>
			</td>
		</tr>
	</table>
	<script>
		
	</script>
</body>
</html>