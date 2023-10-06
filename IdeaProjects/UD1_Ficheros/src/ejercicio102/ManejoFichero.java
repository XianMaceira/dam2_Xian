package ejercicio102;

import java.io.File;
import java.io.IOException;

public class ManejoFichero {

    public static void crearFichero(String fichero) {
        File file = new File(fichero);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Se ha creado el fichero en: " + fichero);
    }

    public static void borrarFichero(String fichero) {
        File file = new File(fichero);
        file.delete();
        System.out.println("Se ha borrado el fichero en: " + fichero);
    }

    public static void crearDirectorio(String ruta) {
        File file = new File(ruta);
        file.mkdir();
        System.out.println("Se ha creado el Directorio: " + ruta);
    }

    public static void borrarDirectorio(String ruta) {
        File file = new File(ruta);
        file.delete();
        System.out.println("Se ha borrado el Directorio: "+ruta);
    }

    public static void listarDirectorio(String ruta) {
        File file = new File(ruta);
        String[] listadoFicheros = file.list();
        System.out.println();
        System.out.println("Listado de: "+ruta);

        for (String item: listadoFicheros) {
            System.out.print(item + " ");
            File ficheroLista = new File(ruta, item);
            if (ficheroLista.isDirectory()) {
                System.out.println("(Subdirectorio)");
            } else {
                System.out.println("(Fichero)");
            }
        }
    }

}
