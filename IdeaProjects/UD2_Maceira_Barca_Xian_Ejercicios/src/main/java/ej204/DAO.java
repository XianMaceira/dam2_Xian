package ej204;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DAO {
    private String tableName;
    private ArrayList<String> sql;
    private String lastSql;
    private Connection connection;
    private ArrayList<String> columnNames;
    public DAO(Connection connection, String tableName) {
        this.tableName = tableName;
        this.connection = connection;
        this.sql = new ArrayList<>();
        this.lastSql = "";
    }
    public ArrayList<DatabaseItem> all() throws Exception {
        sql.add(String.format("SELECT * FROM %s", tableName));
        return get();
    }

    public DAO distinct(String ...fields) {
        sql.add(String.format("SELECT DISTINCT %s FROM %s", String.join(",", fields), tableName));
        return this;
    }

    public DAO select(String ...fields) {
        sql.add(String.format("SELECT %s FROM %s", String.join(",", fields), tableName));
        //System.out.println(sql);
        return this;
    }

    public DAO select() {
        return select("*");
    }

    public DAO where(String field, String value) {
        return where(field,"=",value,true);
    }

    public DAO where(String field, int value) {
        return where(field,"=",String.valueOf(value),false);
    }

    public DAO where(String field, String op, String value, boolean isString) {
        if(sql.size() == 0) {
            sql.add(String.format("SELECT * FROM %s",tableName));
        }

        if(isString) {
            sql.add(String.format("WHERE %s %s '%s'",field,op,value));
        } else {
            sql.add(String.format("WHERE %s %s %s",field,op,value));
        }
        return this;
    }

    public DAO orderBy(String field)  {
        sql.add(String.format("ORDER BY %s", field));
        return this;
    }

    public DAO orderBy(String field, String asc) {
        sql.add(String.format("ORDER BY %s %s", field, asc));
        return this;
    }

    public ArrayList<DatabaseItem> get() throws Exception {
        String query = String.join(" ", sql.toArray(String[]::new));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        this.lastSql = query;
        sql.clear();
        return parse(resultSet);
    }

    public ArrayList<DatabaseItem> raw(String query) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        this.lastSql = query;
        return parse(resultSet);
    }

    private ArrayList<DatabaseItem> parse(ResultSet resultSet) throws Exception {
        ArrayList<DatabaseItem> rows = new ArrayList<>();
        this.columnNames = getColumnNames(resultSet);

        while(resultSet.next()) {
            HashMap<String,Object> map = new HashMap<>();
            for(String colName : columnNames) {
                map.put(colName,resultSet.getObject(colName));
            }
            DatabaseItem item = new DatabaseItem(map,columnNames);
            rows.add(item);
        }

        return rows;
    }
    public String getSql() {
        return this.lastSql;
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

    public String getColumnNames() {
        String str = "";
        for(String colName : columnNames) {
            str += String.format("%-14s  ",colName);
        }
        return str;
    }
}