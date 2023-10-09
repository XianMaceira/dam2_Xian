import java.io.*;

public class Main {

    static final int NUM_PROCESOS = 4;
    static final String PREFIJO_FICHEROS = "fich";

    static final String PROJECT_PATH = new File("").getAbsolutePath();

    public static void lanzarSumador(int n1, int n2, String fichResultados) throws IOException {
        String comando;
        comando = "Sumador";

        File directorioSumador;
        directorioSumador = new File("ServiciosProcesos");
        File fichResultado = new File(fichResultados);
        ProcessBuilder pb;

        pb = new ProcessBuilder("java", "-cp", PROJECT_PATH + "\\out\\production\\ServiciosProcesos\\", // Replace with the actual classpath
                comando, String.valueOf(n1), String.valueOf(n2));

        pb.directory(directorioSumador);
        pb.redirectOutput(fichResultado);
        pb.start();
    }

    public static int getResultadoFichero(String nombreFichero) {
        int suma = 0;
        try {
            FileInputStream fichero = new FileInputStream(nombreFichero);
            InputStreamReader fir = new InputStreamReader(fichero);
            BufferedReader br = new BufferedReader(fir);
            String linea = br.readLine();

            if (linea != null) {
                suma = Integer.parseInt(linea);
            } else {
                System.out.println("El archivo está vacío: " + nombreFichero);
            }

            br.close(); // Cerrar el archivo después de leerlo.
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir " + nombreFichero);
        } catch (IOException e) {
            System.out.println("Error al leer " + nombreFichero);
        }
        return suma;
    }

    public static int getSumaTotal(int numFicheros) {
        int sumaTotal = 0;
        for (int i = 1; i <= NUM_PROCESOS; i++) {
            sumaTotal += getResultadoFichero(PROJECT_PATH+"\\files\\" + PREFIJO_FICHEROS + String.valueOf(i));
        }
        return sumaTotal;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int n1 = 20;
        int n2 = 10;
        int salto = (n2 / NUM_PROCESOS) - 1;
        for (int i = 1; i <= NUM_PROCESOS; i++) {
            System.out.println("n1:" + n1);
            int resultadoSumaConSalto = n1 + salto;
            System.out.println("n2:" + resultadoSumaConSalto);
            lanzarSumador(n1, n1 + salto, PROJECT_PATH+"\\files\\"+PREFIJO_FICHEROS + String.valueOf(i));
            n1 = n1 + salto + 1;
            System.out.println("Suma lanzada...");
        }
        Thread.sleep(5000);
        int sumaTotal = getSumaTotal(NUM_PROCESOS);
        System.out.println("La suma total es:" + sumaTotal);
    }
}