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
			conn=DriverManager.getConnection(//url:���� ���ڿ�(Connection String)1.IP 2.��Ʈ��ȣ 3.db��
					"jdbc:mysql://blueskii.iptime.org:3306/team5"
					,"team5","123456"
					);
			System.out.println("���Ἲ��");
		
		} catch (Exception e){
			System.out.println("�������");
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}

}
