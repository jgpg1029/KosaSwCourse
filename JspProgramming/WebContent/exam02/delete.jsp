<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>

<%
int productNo=Integer.parseInt(request.getParameter("product_no"));
%>

<jsp:useBean
	 id="boardexService" 
	 class="service.BoardexService"
	 scope="application"/>
	 
<% boardexService.remove(productNo);  %>	 
	
<%response.sendRedirect("list.jsp");%>