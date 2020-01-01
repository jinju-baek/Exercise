package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	private static Connection conn;

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc.oracle.thin:@127.0.0.1:XE";
	private static final String USER = "java";
	private static final String PASSWORD = "1234";
	
	public static Connection getConnection() {
		try {
			conn = null;
			if (conn == null) {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
