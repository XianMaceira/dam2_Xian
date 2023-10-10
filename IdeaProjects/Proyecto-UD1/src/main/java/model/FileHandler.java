package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
    public class FileHandler {
        private File file;


        public void createFile() throws IOException {
            if (!file.exists()) {
                file.createNewFile();
            }
        }

        public static List<User> readUsers() {
            HashMap<String, User> users = ;
            // Implementar la lectura de usuarios desde el archivo binario
            return users;
        }

        public static void writeUsers(List<User> users) {
            // Implementar la escritura de usuarios en el archivo binario
        }

        public static void addUser(User user) {
            // Implementar la lógica para agregar un usuario al archivo
        }
    }



