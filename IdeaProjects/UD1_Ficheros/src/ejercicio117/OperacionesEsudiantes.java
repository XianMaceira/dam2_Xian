package ejercicio117;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperacionesEsudiantes {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File file = new File("estudiantes.dat");

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
                estudiantes = (List<Estudiante>) ois.readObject();
                System.out.println("Datos de esudiantes.dat cargados");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("..................");
            System.out.println("1. Agregar un nuevo estudiante.");
            System.out.println("2. Mostrar la información de todos los estudiantes almacenados.");
            System.out.println("3. Guardar la información de los estudiantes en un archivo mediante la serialización de objetos.");
            System.out.println("4. Salir del programa.");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Número de Identificación: ");
                    int id = sc.nextInt();
                    System.out.println("Edad: ");
                    int edad = sc.nextInt();
                    System.out.println("Nota promedio");
                    double media = sc.nextDouble();

                    Estudiante newEstudiante = new Estudiante(nombre, id, edad, media);
                    estudiantes.add(newEstudiante);
                    System.out.println("Estudiante añadido");
                    break;
                case 2:
                    System.out.println("Informacion Estudiantes");
                    for (Estudiante estudiante : estudiantes) {
                        System.out.println(estudiante);
                    }
                    break;
                case 3:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                        oos.writeObject(estudiantes);
                        System.out.println("Datos guardados en estudiantes.dat");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Saliendo");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("Opción invalida");
            }

        } while (opcion !=4);

        
    }
}
