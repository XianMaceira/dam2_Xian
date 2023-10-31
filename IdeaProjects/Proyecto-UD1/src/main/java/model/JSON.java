package model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSON {


    private Session session;

        public static void exportToJson(User user, File file) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String json = gson.toJson(user);


            try {

                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(json);

                bufferedWriter.close();

                System.out.println("El archivo JSON se ha creado correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


