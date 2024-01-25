package apartado1;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final String PROJECT_PATH = new File("").getAbsolutePath();

    public static void main(String[] args) throws IOException {
        // Apartado 1
        FileHandler.saveUserInfo(PROJECT_PATH+"\\assets\\apartado1\\usuario.bin");
    }
}