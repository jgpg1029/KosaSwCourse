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
			conn=DriverManager.getConnection(//url:연결 문자열(Connection String)1.IP 2.포트번호 3.db명
					"jdbc:mysql://blueskii.iptime.org:3306/team5"
					,"team5","123456"
					);
			
			String sql="update user3_boards set board_title=?, board_content=?, board_writer=? where board_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "미안해");//(?의 순번,)
			pstmt.setString(2, "솔직하지");
			pstmt.setString(3, "못한내가");
			pstmt.setInt(4, 1);
			int rows=pstmt.executeUpdate();//insert된 행의 수
			
			System.out.println(rows+"개의 행이 수정됨");
			
			
		} catch (Exception e){
		
			e.printStackTrace();
		}finally{
			try {pstmt.close();} catch (SQLException e1) {}
		}
			try {conn.close();} catch (SQLException e) {}
		}

	}
