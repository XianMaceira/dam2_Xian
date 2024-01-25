package apartado1;

import org.mindrot.jbcrypt.BCrypt;

import java.io.*;
import java.util.Scanner;

public class FileHandler {

    public static void saveUserInfo(String ruta) throws IOException {

        User user = new User();

        File file = new File(ruta);
        if (!file.exists()) {

            file.createNewFile();

            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre de ususario: ");
            String name = sc.nextLine();
            user.setName(name);

            System.out.print("Contraseña: ");
            String pass = sc.nextLine();
            String passwd = BCrypt.hashpw(pass, BCrypt.gensalt(10));;
            user.setPasswd(passwd);

            System.out.print("Data de nacemento: ");
            String date = sc.nextLine();
            user.setDate(date);

            File binUser = new File(ruta);
            FileOutputStream fos;
            ObjectOutputStream ois;

            try {

                fos = new FileOutputStream(binUser, true);
                ois = new ObjectOutputStream(fos);

                ois.writeObject(user);

                ois.close();
                fos.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else {
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                User createdUser = (User) ois.readObject();

                System.out.println(createdUser.getName());
                System.out.println(createdUser.getPasswd());
                System.out.println(createdUser.getDate());

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
