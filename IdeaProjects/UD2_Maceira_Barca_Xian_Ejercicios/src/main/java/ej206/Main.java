package ej206;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la acción que desea realizar:");
        System.out.println("1. Consultar nombres de empleados por letra inicial");
        System.out.println("2. Consultar empleados por comisión");
        System.out.println("3. Borrar empleado por número de empleado");
        System.out.println("4. Borrar departamento y sus empleados");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                ConsultaNombres.main(args);
                break;
            case 2:
                ConsultaComision.main(args);
                break;
            case 3:
                BorradoEmpleados.main(args);
                break;
            case 4:
                BorradoDepartamento.main(args);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
