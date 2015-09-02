package Rightdao;

import java.util.List;

public class BoardDaoSelectByPageTest {

	public static void main(String[] args) {
		BoardDao boardDao = BoardDao.getInstance();
		List<Board> list = boardDao.selectByPage(2, 10);

		for(Board board : list) {
			System.out.print(board.getNo() + "\t");
			System.out.print(board.getTitle() + "\t");
			System.out.print(board.getDate() + "\t");
			System.out.print(board.getWriter() + "\t");
			System.out.println(board.getHitcount() + "\t");
		}
	}

}
