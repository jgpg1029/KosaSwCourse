<%@ page contentType="text/html; charset=UTF-8"%>

<% String method=request.getMethod();%>

<% if(method.equals("GET")){%>
 
<h4>게레겟겟</h4>
<img src="../common/images/avata/2seirek_8.gif"/>
<%}else if(method.equals("POST")) {%>
<h4>포오스퉁</h4>
<img src="../common/images/avata/avata1.gif"/>
<%} %>
