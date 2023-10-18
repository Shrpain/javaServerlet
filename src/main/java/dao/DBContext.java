package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	
	protected Connection connection;
	
	public DBContext() {
		try {
			String url="jdbc:sqlserver://DESKTOP-7DB1SJ8:1433;databaseName=QlSach;user=sa;password=123";
			String username ="sa";
			String Password = "123";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, username, Password);
			if (connection != null) {
              System.out.println("Kết nối thành công!");
          } else {
              System.out.println("Kết nối thất bại!");
          }
			
		} catch (ClassNotFoundException  |  SQLException ex) {
			System.out.println(ex);
		}
	}
	

	
}


