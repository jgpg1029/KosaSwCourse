package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import sun.rmi.server.Dispatcher;

public class BoardController {
	private ServletContext application;
	private BoardService boardService;

	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (boardService == null) {
			application = request.getServletContext();
			boardService = (BoardService) application.getAttribute("boardService");
			if (boardService == null) {
				boardService = new BoardService();
				application.setAttribute("boardService", boardService);
			}
		}
		String action = request.getParameter("action");
		switch (action) {
		case "list":
			list(request, response);
			break;
		case "writeForm":writeForm(request,response); break;
		case "write":write(request,response); break;
		}
	}

	private void write(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void writeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("/ewam03/write_Form.jsp");
		rd.forward(request, response);
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardController-list");

		List<Board> list=boardService.getPage(1,10);
		request.setAttribute("list",list);

		
		RequestDispatcher rd = request.getRequestDispatcher("/exam03/list.jsp");
		rd.forward(request, response);
	}
}
