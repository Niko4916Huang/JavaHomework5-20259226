package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DbConnection.getDb());
		
		// result
		/*
		 * com.mysql.cj.jdbc.ConnectionImpl@17c386de
		 */
	}
	
	public static Connection getDb()
	{
		String url = "jdbc:mysql://localhost:3306/receiving?useSSL=false";
		String user = "root";
		String password = "1234";
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
