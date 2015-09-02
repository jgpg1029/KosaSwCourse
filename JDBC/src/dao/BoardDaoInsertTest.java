package dao;

import java.sql.Connection;

public class BoardDaoInsertTest {

	public static void main(String[] args) throws Exception{
		Connection conn=ConnectionManager.getConnection();

		Board board=new Board();
		board.setTitle("오늘은 DAO를 만드는 날");
		board.setContent("배가고파요끙");
		board.setWriter("허니밀크자몽");
		
		BoardDao boardDao=new BoardDao(conn);
		Integer pk=boardDao.insert(board);
		
		if(pk!=null){
			System.out.println(pk+"번 게시물이 저장됨");
		}else{
			System.out.println("저장실패");
		}
		conn.close();
	}

}
