package ejercicio105;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ClasificaDirectorio implements FilenameFilter {

    public static void moveFile(File src, File dest) throws IOException {
        Files.move(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    public static void main(String[] args) {
        ClasificaDirectorio cd = new ClasificaDirectorio();
        cd.segunExtension("C:\\Test");
    }

    void segunExtension(String dir) {
        File ruta = new File(dir);

        if(!ruta.isDirectory()) {
            System.err.println("La ruta introducida no es un directorio.");
            return;
        }

        File[] listaArchivos = ruta.listFiles();
        Set<String> extensiones = new HashSet<>();
        for (int i=0; i<listaArchivos.length; i++) {
            String nombreArchivo = listaArchivos[i].getName();
            extensiones.add(listaArchivos[i].getName().substring(nombreArchivo.lastIndexOf(".")+1).toUpperCase());
        }
        // Creamos las carpetas
        for (String ext : extensiones) {
            File f = new File(dir, ext);
            f.mkdir();
        }
        // Movemos los archivos
        for (File archivo : listaArchivos) {
                String nombreArchivo = archivo.getName();
                String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toUpperCase();
                File destino = new File(dir, extension + File.separator + nombreArchivo);

                try {
                    Files.move(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Movido " + nombreArchivo + " a " + extension + File.separator + nombreArchivo);
                } catch (IOException e) {
                    System.err.println("Error al mover el archivo " + nombreArchivo + ": " + e.getMessage());
                }
        }

    }


    @Override
    public boolean accept(File dir, String name) {
        return false;
    }
}
