package ejercicio110;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoverFichero {
    public static void main(String[] args) {
        Path org = Paths.get("C:\\Users\\dam2_alu11\\dam2\\Acceso a bases\\UD1\\TEST\\TEST 110\\dir\\origen.txt");
        Path dest = Paths.get("C:\\Users\\dam2_alu11\\dam2\\Acceso a bases\\UD1\\TEST\\TEST 110\\dir\\subdirectorio\\destino-sub.txt");


        try {
            Files.move(org, dest, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Se ha movido el fichero");
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}