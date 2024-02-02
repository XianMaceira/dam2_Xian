package simple;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryProcessor {
    private Connection connection;
    private int count;

    public QueryProcessor(Connection connection) {
        this.connection = connection;
        this.count = 0;
    }

    public void query(String sql) throws Exception {
        count++;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        print(rs, sql);
    }

    public void queryFromFile(String pathStr) throws Exception {
        Path path = Paths.get(pathStr);
        String sql = Files.readString(path);
        query(sql);
    }

    private void print(ResultSet rs, String sql) throws Exception {
        System.out.printf("%s%s   #%s   %s%n%s%s%s%n", ANSI.YELLOW_BACKGROUND, ANSI.BLACK, count, ANSI.RESET, ANSI.PURPLE, sql, ANSI.RESET);
        ArrayList<String> columns = getColumnNames(rs);
        System.out.println(getHeaderRow(columns));

        while(rs.next()) {
            String row = "";
            for(int i = 1; i<=columns.size(); i++) {
                row += String.format("%-14s  ",rs.getObject(i));
            }
            System.out.println(row);
        }

        System.out.println("\n");
    }

    private ArrayList<String> getColumnNames(ResultSet resultSet) throws Exception {
        ArrayList<String> names = new ArrayList<>();
        ResultSetMetaData metadata = resultSet.getMetaData();
        int columns = metadata.getColumnCount();

        for (int i = 1; i <= columns; i++) {
            String name = metadata.getColumnLabel(i);
            names.add(name);
        }

        return names;
    }

    public String getHeaderRow(ArrayList<String> columnNames) {
        String str = ANSI.YELLOW_BACKGROUND + ANSI.BLACK;
        for(String colName : columnNames) {
            str += String.format("%-14s  ",colName);
        }
        return str + ANSI.RESET;
    }
}
