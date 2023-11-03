package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XML {

    public static void exportXmlUser(User user, File file) {

        String name = user.getName();
        String age = user.getAge();
        String mail = user.getEmail();

        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xmlBuilder.append("<usuario>");
        xmlBuilder.append("<nombre>").append(name).append("</nombre>");
        xmlBuilder.append("<edad>").append(age).append("</edad>");
        xmlBuilder.append("<correo>").append(mail).append("</correo>");
        xmlBuilder.append("</usuario>");



        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(xmlBuilder.toString());


            bufferedWriter.close();

            System.out.println("El archivo XML se ha creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
