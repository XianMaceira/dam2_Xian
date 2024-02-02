package querybuilder;

import db.LocalConnection;
import java.sql.Connection;

public class Main {
    private static Connection connection;
    private static DAO emp;
    private static DAO dep;

    public static void main(String[] args) throws Exception {
        connection = LocalConnection.get("empleados");
        QueryPrint qp = new QueryPrint();

        emp = new DAO(connection,"emp");
        dep = new DAO(connection,"depto");

        qp.show(emp, emp.all()); // 1
        qp.show(dep, dep.all()); // 2
        qp.show(emp, emp.where("puesto","CONTABLE").get()); // 3
        qp.show(emp, emp.where("puesto","CONTABLE").orderBy("nomemp").get()); // 4
        qp.show(emp, emp.where("puesto","CONTABLE").orderBy("nomemp","desc").get()); // 5
        qp.show(emp, emp.select("nomemp","sal").get()); // 6
        qp.show(dep, dep.select("nomdep").get()); // 7
        qp.show(dep, dep.select("nomdep").orderBy("localidad").get()); // 8
        qp.show(emp, emp.select("nomemp","puesto").orderBy("sal").get()); // 9
        qp.show(emp, emp.select("nomemp","puesto").orderBy("sal").get()); // 10

        qp.show(emp, emp.select("sal","comision").where("numdep",3).get()); // 11
        qp.show(emp, emp.select("sal","comision").where("numdep",3).orderBy("comision").get()); // 12
        qp.show(emp, emp.distinct("comision").get()); // 13
        qp.show(emp, emp.select("nomemp", "sal + 1000 AS nuevo_salario").where("numdep",3).get()); // 14
        qp.show(emp, emp.select("nomemp", "sal", "comision").where("comision",">","(sal/2)",false).get()); // 15
        qp.show(emp, emp.select("nomemp", "sal", "comision").where("comision","<=","(sal * 0.25)",false).get()); // 16
    }
}
