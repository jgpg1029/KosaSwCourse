<%@ page contentType="text/html; charset=UTF-8"%>

<%-- 클라이언트가 보낸 데이터를 Board 객체에 저장 --%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="boardex" class="dto.Boardex">
	<jsp:setProperty name="boardex" property="*"/>
</jsp:useBean>

<!-- applicaiton 범위의 BoardService 객체 사용 -->
<jsp:useBean 
	id="boardexService" 
	class="service.BoardexService"
	scope="application"/><!--어플리케이션에 있으면 가져오고 없으면 생성-->

<%-- BoardexService의 add() 메소드를 호출 --%>	
<%boardexService.add(boardex);%>

<!-- BoardexService의 add() 메소드를 호출-->
<%response.sendRedirect("list.jsp"); %>
