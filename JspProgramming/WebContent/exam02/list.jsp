<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.*" %>

<jsp:useBean
	 id="boardexService" 
	 class="service.BoardexService"
	 scope="application"/>

<%
List<Boardex> list=boardexService.getPage(1, 10);
%>


<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		<style type="text/css">
				table{
					width:100%;
					border-collapse:collapse;
					font-size:small;
					
				}
				table, th, td{
					border:1px solid black;
					text-align:center;
				}
				th{
					background-color:orange;
				}
				#buttonGroup{
					margin:10px;
					text-align:center;
				}
			</style>
		</head>
		<body>
			<h4>상품 목록</h4>
			<table >
				<tr>
					<th style="width:50px">번호</th>
					<th>상품명</th>
					<th style="width:60px">가격</th>
				</tr>
				
				<%for(Boardex boardex:list) {%>
				<tr>
					<td><%=boardex.getNo() %></td>
					<td><a href="detail.jsp?product_no=<%=boardex.getNo() %>"><%=(boardex.getName().length()>10)?boardex.getName().substring(0,10):boardex.getName() %></a></td>
					<td><%=boardex.getPrice() %></td>
				</tr>
				<%} %>
			</table>
			<div id="buttonGroup">
				<a href="write_form.jsp">
					<img src="../common/images/board/write.gif"/>
				</a>
			</div>

		</body>
	</html>