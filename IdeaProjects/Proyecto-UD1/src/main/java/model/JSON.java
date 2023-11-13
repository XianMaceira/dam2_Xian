package model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSON {



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

        public static void exportAllUsersJSON (Users users, File path) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            try {
                if (!path.exists()) {
                    path.mkdirs();
                }

                File file = new File(path, "users.json");
                FileWriter fw = new FileWriter(file);
                BufferedWriter bf = new BufferedWriter(fw);

                bf.write("[\n");

                boolean checkFirstUser = true;

                for (User user: users.getAllUsers()) {
                    String json = gson.toJson(user);

                    if (!checkFirstUser) {
                        bf.write(",\n");
                    } else {
                        checkFirstUser = false;
                    }

                    bf.write(json);
                }

                bf.write("\n");
                bf.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


