import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            // SQLite
            Connection sqliteConnection = SQLiteConnection.getConnection();
            System.out.println("Conexión con SQLite establecida.");

            // MySQL
            Connection mysqlConnection = MySQLConnection.getConnection();
            System.out.println("Conexión con MySQL establecida.");

            // MariaDB
            Connection mariaDBConnection = MariaDBConnection.getConnection();
            System.out.println("Conexión con MariaDB establecida.");

            // PostgreSQL
            Connection postgreSQLConnection = PostgreSQLConnection.getConnection();
            System.out.println("Conexión con PostgreSQL establecida.");

            // Oracle
            Connection oracleConnection = OracleConnection.getConnection();
            System.out.println("Conexión con Oracle establecida.");

            // Microsoft SQL Server
            Connection sqlServerConnection = MicrosoftSQLServerConnection.getConnection();
            System.out.println("Conexión con Microsoft SQL Server establecida.");

            // Puedes realizar operaciones con las conexiones aquí

            // Cierra las conexiones
            sqliteConnection.close();
            mysqlConnection.close();
            mariaDBConnection.close();
            postgreSQLConnection.close();
            oracleConnection.close();
            sqlServerConnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
