package ej204;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseItem {
    private HashMap<String, Object> map;
    private ArrayList<String> columnNames;

    public DatabaseItem(HashMap<String, Object> map, ArrayList<String> columnNames) {
        this.map = map;
        this.columnNames = columnNames;
    }

    @Override
    public String toString() {
        String str = "";
        for(String colName : columnNames) {
            str += String.format("%-14s  ",map.get(colName));
        }
        return str;
    }
}
