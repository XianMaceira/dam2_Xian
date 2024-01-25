package apartado2;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class jsonGenerator {

    public static void jsonGen () throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una ruta: ");
        File directorio = new File(sc.nextLine());

        System.out.println("Introduce una cadena: ");
        String cadena = sc.nextLine();

        if (directorio.isDirectory()) {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("total", countFiles(directorio));
            jsonObject.addProperty("matches", countFilesMatches(directorio, cadena));

            File[] files = directorio.listFiles();

            JsonArray filesJsonArray = new JsonArray();
            for (File f : files)  {
                if (f.getName().contains(cadena))
                filesJsonArray.add(f.getName()+".txt");
            }
            jsonObject.add("files", filesJsonArray);

            String rutaPadre = directorio.getParent();

            File file = new  File(rutaPadre+"\\filter.json");
            file.createNewFile();
            String outputFile = file.getAbsolutePath();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

                writer.write(String.valueOf(jsonObject));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.err.println("La ruta introducida no es un directorio");
        }

    }

    public static int countFiles(File file) {

        int totalFiles = file.listFiles().length;

        return totalFiles;
    }

    public static int countFilesMatches(File file, String cadena) {
        int matchesFiles = 0;

        File[] files = file.listFiles();

        for (File f : files) {
            if (f.getName().contains(cadena)) {
                matchesFiles++;
            }
        }

        return matchesFiles;
    }

}
