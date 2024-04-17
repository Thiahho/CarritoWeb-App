package DB;

import java.sql.*;

public class DBConexion {

	private static Connection con;
	static String url="jdbc:mysql://localhost:3306/shopc";
	static String user="root";
	static String pass="123456";
	
	public static Connection getConnection() throws ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url,user,pass);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
	