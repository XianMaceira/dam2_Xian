package ejercicio119;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DirectorioAZip {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese la ruta del directorio a comprimir:");
            String directorioPath = reader.readLine();


            File directorio = new File(directorioPath);
            if (!directorio.exists() || !directorio.isDirectory()) {
                System.err.println("El directorio ingresado no es válido.");
                return;
            }


            String nombreArchivoZip = directorio.getName() + ".zip";


            File archivoZip = new File(directorio.getParent(), nombreArchivoZip);


            FileOutputStream fos = new FileOutputStream(archivoZip);
            ZipOutputStream zipOut = new ZipOutputStream(fos);


            comprimirAZip(directorio, directorio.getName(), zipOut);


            zipOut.close();
            fos.close();

            System.out.println("Compresión completada con éxito. El archivo ZIP se ha creado en: " + archivoZip.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void comprimirAZip(File ruta, String nombreDirectorio, ZipOutputStream zipOut) throws IOException {
        File[] archivos = ruta.listFiles();
        for (File archivo : archivos) {
            if (archivo.isDirectory()) {

                comprimirAZip(archivo, nombreDirectorio + "/" + archivo.getName(), zipOut);
            } else {

                FileInputStream fis = new FileInputStream(archivo);
                ZipEntry zipEntry = new ZipEntry(nombreDirectorio + "/" + archivo.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, length);
                }

                fis.close();
            }

        }
    }
}
