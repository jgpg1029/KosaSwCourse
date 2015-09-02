package Rightdao;

public class BoardDaoSelectByPkTest {

	public static void main(String[] args) {
		BoardDao boardDao = BoardDao.getInstance();
		Board board = boardDao.selectByPk(60);
		if(board != null) {
			System.out.println("번호: " + board.getNo());
			System.out.println("제목: " + board.getTitle());
			System.out.println("내용: " + board.getContent());
			System.out.println("날짜: " + board.getDate());
			System.out.println("글쓴이: " + board.getWriter());
			System.out.println("조회수: " + board.getHitcount());
		} else {
			System.out.println(60 + "번 게시물이 존재하지 않음");
		}
	}

}
