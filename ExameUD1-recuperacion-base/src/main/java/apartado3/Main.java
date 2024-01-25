package apartado3;

import java.io.File;
import java.io.IOException;

public class Main {

    private static final String PROJECT_PATH = new File("").getAbsolutePath();


    public static void main(String[] args) throws IOException {
        // Apartado 3
        // Ruta: PROJECT_PATH\assets\apartado3\words
        textGenerator.textGen();
    }
}