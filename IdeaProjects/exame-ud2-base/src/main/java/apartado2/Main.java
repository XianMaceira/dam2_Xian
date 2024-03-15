package apartado2;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String DB_URL = "jdbc:mysql://localhost/flights";
    private static final String USER = "root";
    private static final String PASSWORD = "abc123.";

    public static void main(String[] args) {

        try (Connection cn = DriverManager.getConnection(DB_URL, USER, PASSWORD)){

            DatabaseMetaData md = cn.getMetaData();

            ResultSet rs = md.getCatalogs();
            int contador = 0;

            while (rs.next()) {
                String name = rs.getString("TABLE_CAT");
                if (!excluirDatabaseDelSistema(cn,name)){
                    contador++;
                }

            }

            System.out.println("MYSQL: "+contador+" schemas");

            rs = md.getCatalogs();

            while (rs.next()) {
                String nombre = rs.getString("TABLE_CAT");
                if (!excluirDatabaseDelSistema(cn, nombre)) {
                    System.out.println("DB: "+nombre+" ("+contarTablas(cn, nombre)+ " tables)");
                    ResultSet rs2 = md.getTables(nombre, null, null, null);
                    while (rs2.next()){
                        String nombreTabla = rs2.getString("TABLE_NAME");
                        System.out.println("# " + nombreTabla + " (" + contarFilas(cn,nombre,nombreTabla) + " rows)");
                        mostrarColumnas(cn, nombre, nombreTabla);
                    }

                }
            }
            cn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean excluirDatabaseDelSistema(Connection cn, String name) throws SQLException {
        String[] systemSchemas = {"information_schema", "mysql", "performance_schema", "sys"};
        for (String systemSchema : systemSchemas) {
            if (systemSchema.equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static int contarTablas(Connection cn, String nombre) throws SQLException {
        DatabaseMetaData md = cn.getMetaData();
        ResultSet rs = md.getTables(nombre, null, null, null);
        int contador = 0;

        while (rs.next()) {
            contador++;
        }

        return contador;
    }

    private static int contarFilas(Connection cn, String nombre, String nombreTabla) throws SQLException {
        Statement statement = cn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM " + nombre + "." + nombreTabla);
        resultSet.next();
        return resultSet.getInt(1);
    }

    private static void mostrarColumnas(Connection cn, String nombre, String nombrTabla) throws SQLException {
        DatabaseMetaData metaData = cn.getMetaData();
        ResultSet columns = metaData.getColumns(nombre, null, nombrTabla, null);

        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            System.out.println("  - " + columnName);
        }
    }
}

