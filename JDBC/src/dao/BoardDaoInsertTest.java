package dao;

import java.sql.Connection;

public class BoardDaoInsertTest {

	public static void main(String[] args) throws Exception{
		Connection conn=ConnectionManager.getConnection();

		Board board=new Board();
		board.setTitle("������ DAO�� ����� ��");
		board.setContent("�谡���Ŀ��");
		board.setWriter("��Ϲ�ũ�ڸ�");
		
		BoardDao boardDao=new BoardDao(conn);
		Integer pk=boardDao.insert(board);
		
		if(pk!=null){
			System.out.println(pk+"�� �Խù��� �����");
		}else{
			System.out.println("�������");
		}
		conn.close();
	}

}
