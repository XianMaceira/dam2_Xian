package ej205;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
   private String engine;

    public DatabaseConnection(String engine) {
        this.engine = engine;
    }

    public Connection getConnection() {
        if (engine=="mysql") {

        }

        if (engine=="sqlite") {

        }
        return ;
    }
}
