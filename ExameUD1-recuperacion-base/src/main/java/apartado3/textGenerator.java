package apartado3;

import java.io.*;
import java.util.*;

public class textGenerator {
    public static void textGen() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una ruta: ");
        File directorio = new File(sc.nextLine());
        String linea;


        if (directorio.isDirectory()) {
            File[] files = directorio.listFiles();
            List<String> palabras = new ArrayList<>();
            for (File f:files) {
                if (!f.getName().contains("palabras")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                        while ((linea = reader.readLine()) != null) {
                            palabras.add(linea);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            Collections.sort(palabras);

            try (PrintWriter pw = new PrintWriter(new FileWriter(new File(directorio, "palabras.txt")))) {
                for (String p:palabras) {
                    pw.println(p);
                }
            }

        } else {
            System.err.println("directorio no valido");
        }
    }
}
