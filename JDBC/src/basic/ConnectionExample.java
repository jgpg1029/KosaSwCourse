package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn=null;
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(//url:연결 문자열(Connection String)1.IP 2.포트번호 3.db명
					"jdbc:mysql://blueskii.iptime.org:3306/team5"
					,"team5","123456"
					);
			System.out.println("연결성공");
		
		} catch (Exception e){
			System.out.println("연결실패");
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}

}
