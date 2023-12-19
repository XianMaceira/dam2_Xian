import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:app.db";
        return DriverManager.getConnection(url);
    }
}
