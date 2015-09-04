<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {
				color: white;
			}
			table {
				width: 100%;
				border-collapse: collapse;
				font-size: small;
			}
			table, th, td {
				border: 1px solid white;
				text-align: center;
			}
			th {
				background-color: pink;
			}
			
			#buttonGroup {
				margin: 10px;
				text-align: center;
			}
			
			#buttonGroup a {
				display:inline-block;
				width: 70px;
				line-height: 30px;
				text-decoration: none;
				font-size: small;
				color: white;
				border: 1px solid darkgray;
				background-color: gray;
				font-weight: bold;
			}
			#buttonGroup a:hover {
				color: black;
				background-color: lightgray;
			}
			#pager {
				margin-top: 5px;
				text-align: center;
				font-size: small;
			}
			#pager a{
				text-decoration:none;
				color: white;

			}
			#buttonGroup a:hover {
				color: black;
				background-color: lightgray;
			}
			#pager a:hover{
				color:gray;
			}
			
			#pager a.pageNo{
				margin-left:5px;
				margin-right:5px;
			}
			
			#pager a.pageNo.selected{
				color:aqua;
			}
			
			.title{
				text-decoration:none;
				color:white;
			}
			
			.title:hover{
				color:gray;
			}
		</style>
	</head>
	
	<body>
		<h4>상품 목록</h4>
		
		<table>
			<tr>
				<th style="width:50px">번호</th>
				<th>상품명</th>
				<th style="width:60px">가격</th>
			</tr>
			
			<c:forEach var="product" items="${list}">
				<tr>
					<td>${product.no}</td>
					<td><a class="title" href="detail?productNo=${product.no}">${product.name}</a></td>
					
					<td>${product.price}</td>
				</tr>
			</c:forEach>
			
		</table>
		<div id="pager">
			<a href="list?pageNo=1">[처음]</a>
			
			<c:if test="${groupNo>1}">
				<a href="list?pageNo=${startPageNo-pagesPerGroup }">[이전]</a>
			</c:if>
		
			<c:forEach var="i" begin="${startPageNo }" end="${endPageNo }">
				<a class='pageNo <c:if test="${pageNo==i}">selected</c:if>' href="list?pageNo=${i}">${i}</a>
			</c:forEach>
			
			<c:if test="${groupNo<totalGroupNo }">
				<a href="list?pageNo=${endPageNo+1 }">[다음]</a>
			</c:if>	
			
			<a href="list?pageNo=${totalPageNo}">[맨끝]</a>
		</div>
		
		<div id="buttonGroup">
			<a href="writeForm">상품추가</a>
		</div>
	</body>
</html>








