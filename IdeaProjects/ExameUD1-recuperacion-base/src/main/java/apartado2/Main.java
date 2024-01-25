package apartado2;

import apartado1.FileHandler;

import java.io.File;
import java.io.IOException;

public class Main {

    private static final String PROJECT_PATH = new File("").getAbsolutePath();

    public static void main(String[] args) throws IOException {
        // Apartado 2
        // Cadena: PROJECT_PATH+"\\assets\\apartado2\\dir"
        jsonGenerator.jsonGen();

    }
}