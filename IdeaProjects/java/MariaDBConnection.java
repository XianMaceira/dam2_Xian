import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306";
        String user = "root";
        String password = "abc123.";
        return DriverManager.getConnection(url, user, password);
    }
}

