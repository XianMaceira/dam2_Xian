package ej204;


import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection = LocalConnection.get("empleados");
        QueryProcessor p = new QueryProcessor(connection);

        p.query("SELECT * FROM emp"); // 1
        p.query("SELECT * FROM depto"); // 2
        p.query("SELECT * FROM emp WHERE puesto = 'CONTABLE'"); // 3
        p.query("SELECT * FROM emp WHERE puesto = 'CONTABLE' ORDER BY nomemp"); // 4
        p.query("SELECT * FROM emp WHERE puesto = 'CONTABLE' ORDER BY nomemp DESC"); // 5
        p.query("SELECT nomemp, sal FROM emp"); // 6
        p.query("SELECT nomdep FROM depto"); // 7
        p.query("SELECT nomdep AS NOMBRE_DEPTO FROM depto ORDER BY localidad"); // 8
        p.query("SELECT nomemp, puesto, sal FROM emp ORDER BY sal DESC"); // 9
        p.query("SELECT nomemp, puesto, sal FROM emp ORDER BY puesto, sal DESC"); // 10

        int queryCount = 33;
        for(int i=11; i<=queryCount; i++) {
            String path = String.format("sql/%d.sql",i); // 11 - 33
            p.queryFromFile(path);
        }
    }
}
