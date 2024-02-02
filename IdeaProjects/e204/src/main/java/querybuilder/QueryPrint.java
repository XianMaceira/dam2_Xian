package querybuilder;

import java.util.ArrayList;

public class QueryPrint {
    int count;

    public QueryPrint() {
        this.count = 0;
    }

    public <T> void show(DAO dao, ArrayList<T> arrayList) {
        count++;
        System.out.println("");
        System.out.println("");
        System.out.println("==========================================================================");
        System.out.println("APARATADO " + count);
        System.out.println(dao.getSql());
        System.out.println("==========================================================================");

        System.out.println(dao.getColumnNames());
        for(Object element : arrayList) {
            System.out.println(element);
        }
    }
}
