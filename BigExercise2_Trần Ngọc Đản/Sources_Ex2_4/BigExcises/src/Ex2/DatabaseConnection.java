package Ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class DatabaseConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cdstore?useUnicode=true&characterEncoding=utf8";
    private static final String JDBC_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = null;

    /**
     * connect to database.
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER_CLASS);
        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        return conn;
    }
}
