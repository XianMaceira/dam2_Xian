package ejercicio109;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopiaFichero {
    public static void main(String[] args) {
        Path org = Paths.get("C:\\Users\\dam2_alu11\\dam2\\Acceso a bases\\UD1\\TEST\\TEST 109\\origen.txt");
        Path dest = Paths.get("C:\\Users\\dam2_alu11\\dam2\\Acceso a bases\\UD1\\TEST\\TEST 109\\destino.txt");


        try {
            Files.copy(org, dest, StandardCopyOption.REPLACE_EXISTING);

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
