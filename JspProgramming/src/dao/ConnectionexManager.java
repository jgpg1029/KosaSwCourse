package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionexManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connec = DriverManager.getConnection(
			"jdbc:mysql://blueskii.iptime.org:3306/team5", 
			"team5", "123456"
		);
		return connec;
	}
}
