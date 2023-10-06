package ejercicio116;

import java.io.*;
import java.util.Scanner;

public class Refranes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una vocal");
        char vocalSolicitada = sc.next().charAt(0);


        if (!esVocal(vocalSolicitada)) {
            System.out.println("No has introducido un vocal");
            sc.close();
            return;
        }

        String nomArcEntrada = "refranes.txt";
        String nomArcSalida = "refranes_CON_"+vocalSolicitada+".txt";

        try {
            FileReader ArcEntrada = new FileReader(nomArcEntrada);
            BufferedReader lector = new BufferedReader(ArcEntrada);

            FileWriter ArcSalida = new FileWriter(nomArcSalida);
            BufferedWriter writer = new BufferedWriter(ArcSalida);

            String linea;
            while ((linea = lector.readLine()) != null) {
                String lineaReemplazada = ReemplazarVocal(linea, vocalSolicitada);
                writer.write(lineaReemplazada);
                writer.newLine();
            }

            lector.close();
            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean esVocal(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static String ReemplazarVocal (String texto, char vocalSolicitada) {
        return texto.replaceAll("[aeiouAEIOU]", String.valueOf(vocalSolicitada));
    }
}
