<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>

<%
int productNo=Integer.parseInt(request.getParameter("product_no"));
%>

<jsp:useBean
	 id="boardexService" 
	 class="service.BoardexService"
	 scope="application"/>
	 
<% Boardex board=boardexService.getBoard(productNo); %>	 
	 
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<style type="text/css">
				body{
					font-family:"돋움";
					font-size:12px;
				}
				span{
					display:inline-block;
					margin:3px 10px;
					
				}
				
				span.title{
					border:1px solid darkgray;
					background: lightgray;
					width:70px;
					text-align:center;
				}
				
				pre{
					margin:10px;
					border:1px solid darkgray;
					padding:10px;
					width:300px;
					height:100px;
					font-size:12px;
					
				}
				
			</style>
			<script type="text/javascript">
				function sendData(){
					//값의 유효성 검사
					//var modifyForm=document.querySelector("#modifyForm");
					var modifyForm=document.modifyForm;
					
					var name=document.modifyForm.name;
					
					var price=document.modifyForm.price;
					
					if(name.value==""||price.value==""){
						alert("이름과 가격은 있어야함");
						return;
					}
					//서버로 전송
					modifyForm.submit();
				}
			</script>
		</head>
		<body>
			<h4>상품상세 보기</h4>
			<form id="modifyForm" name="modifyForm" method="post" action="modify.jsp">
				<span class="title">번호:</span>
				<span class="content"><%=board.getNo() %></span>
				<input type="hidden" name="no" value="<%=board.getNo()%>" /><br/>
				
				<span class="title">상품명:</span>
				<input id="name" type="text" name="name" value="<%=board.getName() %>"/><br/>
				
				<span class="title">가격:</span>
				<input id="price" type="text" name="price" value="<%=board.getPrice() %>"/><br/>
			</form>
			<div id="buttonGroup">
				
				<a href="javascript:sendData()">[수정]</a>
				<a href="detail.jsp?product_no=<%=board.getNo()%>">[취소]</a>
			</div>

		</body>
	</html>