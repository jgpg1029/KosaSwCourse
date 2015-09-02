package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(// url:연결 문자열(Connection
												// String)1.IP 2.포트번호 3.db명
					"jdbc:oracle:thin:@70.12.108.154:1521:orcl", "user0", "12345");
		} catch (Exception e) {
		}
		return conn;
	}

}
