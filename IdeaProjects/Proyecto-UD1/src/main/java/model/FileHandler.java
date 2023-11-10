package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class FileHandler {
    //private static final String FILE_NAME = "usuarios.bin";
    private static final byte[] HEADER = { (byte) 0xFF, (byte) 0xEE, (byte) 0x20, (byte) 0x23, (byte) 0xEE, (byte) 0xFF };

    private File file;

    public FileHandler(String filename) throws IOException {
        //Users users;
        file = new File(filename);
    }

    public Users load() throws IOException {
        if (!file.exists()) {
            createFile();
        } else if (checkHeader()){
            return charge();
        }
        return null;
    }

    private boolean checkHeader() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){

            byte[] readBytes = bis.readNBytes(HEADER.length);
            int result = Arrays.compare(HEADER, readBytes);

            if (result==0) {
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Users charge() {
        try (FileInputStream fis = new FileInputStream(file)){

            fis.readNBytes(HEADER.length);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Users users = (Users) ois.readObject();
            System.out.println(users);
            return users;

        } catch (IOException | ClassNotFoundException e) {
            return null;
        }

    }

    public void createFile() throws IOException {
        file.createNewFile();
        Users userList = new Users();
        User adminUser = new User("admin", "admin", "0", "admin@admin.local");
        userList.addUser(adminUser);
        saveUsers(userList);
    }

    public void saveUsers(Users users) {
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            fos = new FileOutputStream(file);
            fos.write(HEADER);
            oos = new ObjectOutputStream(new FileOutputStream(file, true));
            oos.writeObject(users);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


