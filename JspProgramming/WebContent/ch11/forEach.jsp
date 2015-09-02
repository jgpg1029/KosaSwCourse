<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	forEach.jsp
	<hr />

	<c:forEach var="i" begin="1" end="5">
			${i }<br />
	</c:forEach>

	<hr />
	<c:forEach var="i" begin="1" end="10" step="2">
			${i }<br />
	</c:forEach>

	<hr />
	<%
		List<String> names = new ArrayList<String>();
		names.add("홍길동");
		names.add("장자몽");
		names.add("윤덕이");
		request.setAttribute("names", names);
	%>

	<c:forEach var="i" items="${names }" varStatus="status">
			first:${status.first},
			last:${status.last},
			index:${status.index},
			index:${status.count}
			i:${i }<br />
	</c:forEach>


	<c:forEach var="name" items="${names }" varStatus="status">
		<c:if test="${status.first }">
			<ul>
		</c:if>

		<li>${name}</li>


		<c:if test="${status.last}">

			</ul>
		</c:if>
	</c:forEach>
</body>
</html>