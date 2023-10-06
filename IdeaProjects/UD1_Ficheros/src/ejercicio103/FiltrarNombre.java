package ejercicio103;

import java.io.File;
import java.io.FilenameFilter;

public class FiltrarNombre implements FilenameFilter {

    private String extension;

    public FiltrarNombre(String extension) {
        this.extension = extension;
    }

    public void filtrar(String ruta, String extension) {
        File directorio = new File(ruta);

            File[] archivos = directorio.listFiles(this);
            if (archivos != null) {
                for (File archivo : archivos) {
                    System.out.println(archivo.getName());
                }
            } else {
                System.out.println("No se encontraron archivos con la extensión " + extension);
            }
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith("." + extension);
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\dam2_alu11\\dam2\\Interfaces";
        String extension = "txt";

        FiltrarNombre filtro = new FiltrarNombre(extension);
        filtro.filtrar(ruta, extension);
    }
}

