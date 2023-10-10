import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String fileName = "archivo.txt";
        String clave = "clave33";

        System.out.println("Escribe algo en el fichero: ");
        try (PrintWriter writer = new PrintWriter(fileName)) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            writer.println(userInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String contenido = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            contenido = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (contenido != null && contenido.equals(clave)) {
            System.out.println("La clave es correcta. Terminando el programa.");
        } else {
            System.out.println("La clave es incorrecta. Volviendo al proceso 1.");
            String javaHome = System.getProperty("java.home");
            String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
            String classpath = System.getProperty("java.class.path");
            String className = Main.class.getCanonicalName();

            ProcessBuilder processBuilder = new ProcessBuilder(javaBin, "-cp", classpath, className);
            processBuilder.inheritIO();

            try {
                Process proceso1 = processBuilder.start();
                proceso1.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}