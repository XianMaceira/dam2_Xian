package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class FileHandler {
    private static final String FILE_NAME = "usuarios.bin";
    private static final byte[] HEADER = { (byte) 0xFF, (byte) 0xEE, (byte) 0x20, (byte) 0x23, (byte) 0xEE, (byte) 0xFF };

    public FileHandler(String filename) throws IOException {

        Users users;

        File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();

            User user = new User("admin", "admin", "0", "admin@admin");
            users.addUser(user);

        }

        readUsers();
        writeUsers(users.getUsers());

    }


    // Leer usuarios del fichero
    public HashMap<String, User> readUsers() {
        HashMap<String, User> users = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            byte[] header = new byte[HEADER.length];
            ois.read(header);

            // Verificar la cabecera
            if (isHeaderValid(header)) {
                // Leer los usuarios
                while (true) {
                    User user = (User) ois.readObject();
                    users.put(user);
                }
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Escribir usuarios en el fichero
    public void writeUsers(HashMap<String, User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.write(HEADER);

            for (User user : users) {
                oos.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Verificar la cabecera del archivo
    private boolean isHeaderValid(byte[] header) {
        if (header.length != HEADER.length) {
            return false;
        }

        for (int i = 0; i < HEADER.length; i++) {
            if (header[i] != HEADER[i]) {
                return false;
            }
        }

        return true;
    }
}


