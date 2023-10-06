package ejercicio118;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DeterminarTipoFichero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Ingrese la ruta completa del archivo");
            String ruta = sc.nextLine();

            FileInputStream fis = new FileInputStream(ruta);
            byte[] bytes = new byte[8];
            int bytesLeidos = fis.read(bytes);
            fis.close();

            if (bytesLeidos < 8) {
                System.out.println("Bytes insuficientes");
            } else {
                String tipo = tipoArchivo(bytes);
                if (tipo != null) {
                    System.out.println("El archivo es un "+tipo);
                } else {
                    System.out.println("No se pudo detectar el archivo");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String tipoArchivo(byte[] bytes) {
        if (bytes[0] == 0x25 && bytes[1] == 0x50 && bytes[2] == 0x44 && bytes[3] == 0x46) {
            return "PDF";
        } else if (bytes[0] == 0x50 && bytes[1] == 0x4B && bytes[2] == 0x03 && bytes[3] == 0x04) {
            return "ZIP";
        } else if (bytes[0] == 0x37 && bytes[1] == 0x7A && bytes[2] == 0xBC && bytes[3] == 0xAF) {
            return "7Z";
        } else if (bytes[0] == 0x52 && bytes[1] == 0x61 && bytes[2] == 0x72 && bytes[3] == 0x21) {
            return "RAR";
        } else if (bytes[0] == 0x89 && bytes[1] == 0x50 && bytes[2] == 0x4E && bytes[3] == 0x47) {
            return "PNG";
        } else {
            return null;
        }
    }
}
