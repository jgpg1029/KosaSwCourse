package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		/*resp.setContentType("text/html; charset=UTF-8");
		ServletOutputStream sos=resp.getOutputStream();
		String html="";
		html+="<?DOCTYPE html>";
		html+="<html>";
		html+="	<head>";
		html+="		<meta charset='UTF-8'>";
		html+="	</head>";
		html+="	<body>";
		html+="		<form method='post' action='LoginServlet'>";
		html+="		아이디:<input type='text' name='mid'/><br/>";
		html+="		비번:<input type='password' name='mpass'/><br/>";
		html+="		<input type='submit' value='로그인'/><br/>";
		html+="		</form>";
		html+="	</body>";
		html+="</html>";
		sos.write(html.getBytes("UTF-8"));*/
		
		RequestDispatcher rd=
				req.getRequestDispatcher("ch04/login_form.jsp");
		rd.forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//요청 파라미터 값 받기----------------------------------------------
		req.setCharacterEncoding("UTF-8");
		String mid=req.getParameter("mid");
		String mpass=req.getParameter("mpass");
				
		//요청 처리 하기 ---------------------------------------------------
		
		//응답 보내기 -----------------------------------------------------
		resp.setContentType("text/html; charset=UTF-8");
		ServletOutputStream sos=resp.getOutputStream();
		String html="";
		html+="<?DOCTYPE html>";
		html+="<html>";
		html+="	<head>";
		html+="		<meta charset='UTF-8'>";
		html+="	</head>";
		html+="	<body>";
		html+="		"+mid+"님 로그인 성공";
		html+="	</body>";
		html+="</html>";
		sos.write(html.getBytes("UTF-8"));
	}
}