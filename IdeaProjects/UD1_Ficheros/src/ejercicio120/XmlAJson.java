package ejercicio120;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class XmlAJson {
    public static void main(String[] args) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("bookstore.xml"));
            StringBuilder cadena = new StringBuilder();
            String line = null;

            while ((line = lector.readLine()) != null) {
                cadena.append(line);

            }
            lector.close();

            String xmlEntrada = cadena.toString();

            JSONObject json = XML.toJSONObject(xmlEntrada);
            String jsonString = json.toString(4);
            System.out.println(jsonString);

            String nombreArchivo = "newJson.json";

            // Crea un FileWriter para escribir en el archivo
            FileWriter fileWriter = new FileWriter(nombreArchivo);

            // Puedes utilizar BufferedWriter para mejorar la eficiencia
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribe el contenido de la cadena en el archivo
            bufferedWriter.write(jsonString);

            // Cierra el BufferedWriter para asegurarte de que los datos se escriban en el archivo
            bufferedWriter.close();

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


}
