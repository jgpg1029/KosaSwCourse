package dao;

import java.sql.Connection;

public class BoardDaoDeleteTest {

	public static void main(String[] args) throws Exception{
		Connection conn=ConnectionManager.getConnection();
		BoardDao boardDao=new BoardDao(conn);
		int rows=boardDao.delete(34);
		
		if(rows==1){
			System.out.println(34+"�� �Խù��� ������");
		}else{
			System.out.println(34+"�� �Խù��� �������� ����");
		}
		conn.close();
	}

}
