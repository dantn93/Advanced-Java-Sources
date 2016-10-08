package vd10_workbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class DatabaseConnection {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/phan_cong_nhan_vien_1_1_nam?useUnicode=true&characterEncoding=utf8";
	private static final String JDBC_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "";
	
        //connect to database
	public Connection connect() throws ClassNotFoundException, SQLException{
		Class.forName(JDBC_DRIVER_CLASS);
		Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		return conn;
	}
}
