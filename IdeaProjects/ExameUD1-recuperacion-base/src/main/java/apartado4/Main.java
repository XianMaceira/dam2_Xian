package apartado4;

import java.io.File;

public class Main {
    private static final String PROJECT_PATH = new File("").getAbsolutePath();

    public static void main(String[] args) {
        // Apartado 4
        File file = new File(PROJECT_PATH+"\\assets\\apartado4\\inventario.xml");
        xmlGenerator.xmlGen(file);
    }
}