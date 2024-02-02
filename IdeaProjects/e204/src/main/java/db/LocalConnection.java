package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class LocalConnection {
    public static Connection get(String dbName) throws Exception {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "abc123.");

        String url = "jdbc:mysql://localhost/"+dbName;
        Connection connection = DriverManager.getConnection(url, props);
        return connection;
    }

    public static Connection get() throws Exception {
        return get("");
    }

    public static Connection getDefault() throws Exception {
        return get("app_db");
    }
}
