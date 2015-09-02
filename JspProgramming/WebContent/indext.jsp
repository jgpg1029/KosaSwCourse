<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JspProgramming</title>
		<style type="text/css">
			* {
				margin: 0px;
				padding: 0px;
			}
			body {
				width: 800px;
				margin: 0 auto;
				background-color: #E6E6E6;
			}
			#page-wrapper {
				background-color: #FFFFFF;
				margin: 40px 0px;
				padding: 10px 20px;
				border-radius: 10px;
			}
			
			header {
				margin-bottom: 10px;
			}
			
			nav {
				border-top: 1px solid #C8C8C8;
				border-bottom: 1px solid #C8C8C8;
				display: flex;
				flex-direction: row;
			}
			.menu {
				margin: 5px;
				width: 70px;
				font-style: italic;
			}
			
			#content {
				height: 400px;
				display: flex;
				flex-direction: row;
			}
			aside {
				height: 400px;
				width: 250px;
			}
			#category {
				margin: 10px;
				width: 230px;
				height: 380px;
				overflow-y: scroll;
			}
			.chapter {
				margin-top: 10px;
				font-style: italic;
			}
			#category > a {
				display:block;
				margin: 1px 10px 1px 20px;
				border: 1px solid #C8C8C8;
				text-align: center;
				background: lightgray;
				text-decoration: none;
				border-radius: 7px;
				font-size: small;
			}
			#category > a:hover {
				background: darkgray;
				text-decoration: none;
			}
			#category > a:active {
				background: orange;
				text-decoration: none;
			}
			section {
				height: 400px;
				flex: 1;
			}
			iframe {
				/* border: 0px solid white; */
				border: none;
			}
			footer {
				height: 50px;
				border-top: 1px solid #C8C8C8;
			}
		</style>
	</head>
	
	<body>
		<div id="page-wrapper">
			<header>
				<h1>JspProgramming</h1>
			</header>
			<nav>
				<div class="menu">Menu1</div>
				<div class="menu">Menu2</div>
				<div class="menu">Menu3</div>
				<div class="menu">Menu4</div>
				<div class="menu">Menu5</div>
			</nav>
			<div id="content">
				<aside>
					<div id="category">
						<p class="chapter">[Ch05: JSP 기본 문법]</p>
						<a href="ch05/comment.jsp" target="iframe">주석</a>
						<a href="ch05/directives/index.jsp" target="iframe">지시어</a>
						<a href="ch05/action/index.jsp" target="iframe">표준액션</a>
						<a href="ch05/dec_express/scriptlet1.jsp" target="iframe">스크립트릿1</a>
						<a href="ch05/dec_express/scriptlet2.jsp" target="iframe">스크립트릿2</a>	
						<a href="ch05/dec_express/calc3.jsp" target="iframe">선언문</a>			

						<p class="chapter">[Ch06: JSP 내장 객체]</p>
						<a href="ch06/builtin_object.jsp" target="iframe">JSP 내장 객체 개요</a>	
						<a href="ch06/request/index.jsp" target="iframe">request</a>
						<a href="ch06/response/index.jsp" target="iframe">response</a>	
						<a href="ch06/cookie/index.jsp" target="iframe">cookie</a>	
						<a href="ch06/session/index.jsp" target="iframe">session</a>
						<a href="ch06/application/index.jsp" target="iframe">application</a>
					
						<p class="chapter">[Ch07: JSP 자바 빈즈]</p>
						<a href="ch07/dto.jsp" target="iframe">DTO 이용 방법</a>	
						<a href="ch07/dto_auto_setting.jsp" target="iframe">DTO 값 저장</a>
						<a href="ch07/bean_scope.jsp" target="iframe">빈의 사용 범위</a>
						<a href="ch07/database_form.jsp" target="iframe">데이타베이스 연동</a>
					</div>
				</aside>
				<section>
					<iframe name="iframe" width="100%" height="100%"></iframe>
				</section>
			</div>
			<footer>
				Shin YongKwon
			</footer>
		</div>
	</body>
</html>