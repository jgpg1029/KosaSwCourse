<%@ page contentType="text/html; charset=UTF-8"%>

	 
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<style type="text/css">
		         body {
		            font-size: "12px";
		            color:white;
		         }
		         
		         span {
		            display: inline-block;
		            margin: 2px 10px;
		         }
		         
		         span.title {
		            margin: 2px 10px;
		            border: 1px solid darkgray;
		            background: pink;
		            width: 70px;
		            text-align: center;
		         }
		         
		         pre {
		            margin: 10px;
		            border: 1px solid darkgray;
		            padding: 10px;
		            width: 90%;
		            height: 100px;
		            font-sixe:12px;
		         }
		         
		         #part1 {
		            display: flex;   
		            font-sixe:medium;   
		         }
		         
		         #part1_1 {
		            flex:1;
		         }
		         #part1_2 {
		            width: 120px;
		            margin-right:20px;
		            text-align: center;
		         }
		         #part1_2 {
		            display: block;
		            padding: 10px;
		         }
		         #buttonGroup {
		         	margin:10px;
		            text-align: center;
		            
		         }
		         
		         #buttonGroup a{
		         	display:inline-block;
		        	
		        	width:70px;
		        	line-height:30px;
		        	text-decoration:none;
		        	font-size:small;
		        	color:white;
		        	border: 1px solid darkgray;
		        	background:gray;
		        	font-weight:bold;
		         }
		         
		         #buttonGroup a:hover{
		         	color:black;
		         	background-color:lightgray;
		         }
		         
		         
		      </style>
		</head>
		<body>
			<h4>게시물 보기</h4>
			<div id="part1">
				<div id="part1_1">
					<span class="title">번호:</span>
					<span class="content">${product.no }</span><br/>
					<span class="title">상품명:</span>
					<span class="content">${product.name }</span><br/>
					<span class="title">가격:</span>
					<span class="content">${product.price }</span><br/>
					<span class="title">첨부:</span>
					<span class="content">${product.originalFileName}</span><br/>
				</div>
				
				<div id="part1_2">
					<img src="${pageContext.request.contextPath }/resources/uploadfiles/${product.filesystemName}" width="100px" height="100px"/>
					<button>다운로드</button>
				</div>
			</div>	
			
			
			
			<div id="buttonGroup">
				<a href="list">목록</a>
				<a href="updateForm?productNo=${product.no}">수정</a>
				<a href="delete?productNo=${product.no}">삭제</a>
			</div>

		</body>
	</html>