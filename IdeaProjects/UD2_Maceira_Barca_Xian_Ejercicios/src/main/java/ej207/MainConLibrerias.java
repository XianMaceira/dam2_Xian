package ej207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainConLibrerias {

    public static void main(String[] args) {
        String fileName = "empleados.sql";
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "empleados";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "abc123.";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);

            StringBuilder script = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                script.append(line).append("\n");
            }
            reader.close();

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(script.toString());
            System.out.println("Script executed successfully.");
            conn.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

