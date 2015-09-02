package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {

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
			
			String sql="update user3_boards set board_title=?, board_content=?, board_writer=? where board_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "�̾���");//(?�� ����,)
			pstmt.setString(2, "��������");
			pstmt.setString(3, "���ѳ���");
			pstmt.setInt(4, 1);
			int rows=pstmt.executeUpdate();//insert�� ���� ��
			
			System.out.println(rows+"���� ���� ������");
			
			
		} catch (Exception e){
		
			e.printStackTrace();
		}finally{
			try {pstmt.close();} catch (SQLException e1) {}
		}
			try {conn.close();} catch (SQLException e) {}
		}

	}
