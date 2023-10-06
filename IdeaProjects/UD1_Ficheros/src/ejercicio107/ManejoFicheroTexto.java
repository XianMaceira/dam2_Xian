package ejercicio107;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ManejoFicheroTexto {
    public static void main(String[] args) {
        FicheroTexto fichero = new FicheroTexto("destino.txt");
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Escribir en el fichero.");
            System.out.println("2. Leer fichero.");
            System.out.println("3. Salir.");
            System.out.print("Seleccione una opción: ");

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca el texto a escribir en el fichero: ");
                        String texto = br.readLine();
                        fichero.escribir(texto + "\n");
                        break;
                    case 2:
                        System.out.println("Contenido del fichero:");
                        fichero.leer();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException | IOException e) {
                System.err.println("Error en la entrada. Intente de nuevo.");
            }
        }
    }
}
