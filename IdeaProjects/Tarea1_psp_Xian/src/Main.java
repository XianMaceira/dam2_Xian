import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Proceso 1: Crear o abrir el archivo y esperar a que el usuario escriba en él
        Thread proceso1 = new Thread(() -> {
            try {
                FileWriter fileWriter = new FileWriter("archivo.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                Scanner scanner = new Scanner(System.in);

                System.out.println("Proceso 1: Esperando a que el usuario escriba en el archivo...");
                System.out.println("Escribe algo y presiona Enter:");
                String input = scanner.nextLine();
                bufferedWriter.write(input);
                bufferedWriter.close();

                // Activar proceso 2
                System.out.println("Proceso 1: Iniciando proceso 2...");
                proceso2();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        proceso1.start();
    }

    // Proceso 2: Leer el archivo y verificar la clave
    public static void proceso2() {
        try {
            FileReader fileReader = new FileReader("archivo.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String contenido = bufferedReader.readLine();
            bufferedReader.close();

            String clave = "clave_secreta"; // Clave interna hardcodeada

            if (contenido != null && contenido.equals(clave)) {
                System.out.println("Proceso 2: La clave es correcta. Terminando el programa.");
            } else {
                System.out.println("Proceso 2: La clave es incorrecta. Volviendo al principio del programa.");
                // Eliminar el archivo y reiniciar el proceso 1
                if (borrarArchivo()) {
                    main(new String[]{});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para borrar el archivo
    public static boolean borrarArchivo() {
        File archivo = new File("archivo.txt");
        return archivo.delete();
    }
}
