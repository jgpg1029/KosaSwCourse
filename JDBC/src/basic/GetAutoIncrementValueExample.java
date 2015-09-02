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
			conn=DriverManager.getConnection(//url:연결 문자열(Connection String)1.IP 2.포트번호 3.db명
					"jdbc:mysql://blueskii.iptime.org:3306/team5"
					,"team5","123456"
					
					);
			
			String sql="insert into user3_boards(board_title, board_content,board_writer,board_date) values(?,?,?,now())";//?:매개변수
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "오늘은 화요일");//(?의 순번,)
			pstmt.setString(2, "오늘은 당장 간다");
			pstmt.setString(3, "홍이길이동이");
			//int row=pstmt.executeUpdate();//insert된 행의 수
			pstmt.executeUpdate();
			System.out.println("1개행이 저장됨");
			
			
		} catch (Exception e){
		
			e.printStackTrace();
		}finally{
			try {pstmt.close();} catch (SQLException e1) {}
		}
			try {conn.close();} catch (SQLException e) {}
		}

	}
