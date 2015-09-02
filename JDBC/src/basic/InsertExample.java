package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertExample {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(//url:���� ���ڿ�(Connection String)1.IP 2.��Ʈ��ȣ 3.db��
					"jdbc:mysql://blueskii.iptime.org:3306/team5"
					,"team5","123456"
					);
			
			String sql="insert into user3_boards(board_title, board_content,board_writer,board_date) values(?,?,?,now())";//?:�Ű�����
			pstmt=conn.prepareStatement(sql,new String[]{"board_no"});//�⺻Ű ���� �޾ƿ�. board_no�� ���� �˻��ؼ� ������.
			pstmt.setString(1, "������ ȭ����");//(?�� ����,)
			pstmt.setString(2, "���ô�");
			pstmt.setString(3, "ȫ�̱��̵���");
			int row=pstmt.executeUpdate();//insert�� ���� ��
			//pstmt.executeUpdate();//����
			int boardNo=0;
			if(row==1){
				ResultSet rs=pstmt.getGeneratedKeys();
				if(rs.next()){
					boardNo=rs.getInt(1);//�ڵ������� �÷� ��������.1�� �ؾ���
				}
				rs.close();
			}
			
			
			System.out.println(boardNo+"�� �Խù��� �����");
			
			
		} catch (Exception e){
		
			e.printStackTrace();
		}finally{
			try {pstmt.close();} catch (SQLException e1) {}
		}
			try {conn.close();} catch (SQLException e) {}
		}

	}
