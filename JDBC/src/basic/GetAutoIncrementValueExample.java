package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetAutoIncrementValueExample {

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
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "������ ȭ����");//(?�� ����,)
			pstmt.setString(2, "������ ���� ����");
			pstmt.setString(3, "ȫ�̱��̵���");
			//int row=pstmt.executeUpdate();//insert�� ���� ��
			pstmt.executeUpdate();
			System.out.println("1������ �����");
			
			
		} catch (Exception e){
		
			e.printStackTrace();
		}finally{
			try {pstmt.close();} catch (SQLException e1) {}
		}
			try {conn.close();} catch (SQLException e) {}
		}

	}
