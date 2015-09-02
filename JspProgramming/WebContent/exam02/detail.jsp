<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>


<jsp:useBean
	 id="boardexService" 
	 class="service.BoardexService"
	 scope="application"/>
	 
<%
int productNo=Integer.parseInt(request.getParameter("product_no"));
%> 
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
				}
			</style>
		</head>
		<body>
			<h4>상품상세 보기</h4>
			
			<span class="title">번호:</span>
			<span class="content"><%=board.getNo() %></span><br/>
			<span class="title">상품명:</span>
			<span class="content"><%=board.getName() %></span><br/>
			<span class="title">가격:</span>
			<span class="content"><%=board.getPrice() %></span><br/>
			
			
			<div id="buttonGroup">
				<a href="list.jsp">
					<img src="../common/images/board/list.gif"/>
				</a>
				<a href="modify_form.jsp?product_no=<%=board.getNo() %>">
					<img src="../common/images/board/modify.gif"/>
				</a>
				<a href="delete.jsp?product_no=<%=board.getNo()%>">
					<img src="../common/images/board/delete.gif"/>
				</a>
			</div>

		</body>
	</html>