<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body{
				font-size:small;
				color: white;
			}
			input{
				font-size:12px;
			}
		</style>
	</head>
	
	<body>
		<h4>글쓰기</h4>
		<form method="post" action="write"><!--enctype:인코딩타입 multipart:여러개로 나누겠다-->
			<table id="form_table">
				<tr>
					<td>상품명</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>가격</td>
					
					<td><input type="text" name="price"/></td>
				</tr>
				
				
				<tr>
					<td colspan="2" style="text-align:center;">
					<br/>
						<input type="submit" value="글올리기"/>
						<input type="reset" value="다시작성"/>
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>
