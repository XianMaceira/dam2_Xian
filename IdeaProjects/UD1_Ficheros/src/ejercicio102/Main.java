package ejercicio102;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File F = new File("");
        String rutaFinal = F.getAbsolutePath();

        ManejoFichero.crearFichero("E:\\sample.txt");
        ManejoFichero.borrarFichero("E:\\sample.txt");
        ManejoFichero.crearDirectorio("E:\\arquivos");
        ManejoFichero.borrarDirectorio("E:\\arquivos");
        ManejoFichero.listarDirectorio("C:\\Users\\dam2_alu11\\dam2\\Interfaces");
    }
}
