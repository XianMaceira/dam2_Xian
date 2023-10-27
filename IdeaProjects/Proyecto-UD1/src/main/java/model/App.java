package model;

import org.mindrot.jbcrypt.BCrypt;

import java.awt.event.ActionListener;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;

    private User currUser;


    public App() {
        users = new Users();
    }

    public boolean login(String userName, String passwd) {
        if (users.userExists(userName)) {
            User usuario = users.getUserByName(userName);
            String hash = usuario.getPasswordHash();

            if (BCrypt.checkpw(passwd, hash)) {
                System.out.println("Logged in");
                currUser = usuario;
                return true;
            }
        }
        System.out.println("Log In Failed");
        return false;


    }

    public User getCurrUser() {
        return currUser;
    }



    public Session getSession() {
        return session;
    }

}
