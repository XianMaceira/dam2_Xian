package model;

import gui.UserDetails;
import org.mindrot.jbcrypt.BCrypt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;

    private User currUser;


    public App() {
        session = new Session();
        users = new Users();
    }

    public boolean login(String userName, String passwd) {
        if (users.userExists(userName)) {
            User usuario = users.getUserByName(userName);
            String hash = usuario.getPasswordHash();

            if (BCrypt.checkpw(passwd, hash)) {
                System.out.println("Logged in");
                session.setCurrentUser(users.getUserByName(userName));
                return true;
            }
        }
        System.out.println("Log In Failed");
        return false;


    }

    /*public void openUserWindow() {
        gui.User userWindow = new gui.User(this, currUser.getName());
        userWindow.setVisible(true);
    }*/

    public void showUserDetailsWindow() {
        String name = session.getCurrentUser().getName();
        String age = session.getCurrentUser().getAge();
        String mail = session.getCurrentUser().getEmail();

        UserDetails userDetailsWindow = new UserDetails(this, name, age, mail);
        userDetailsWindow.setVisible(true);
    }

    public void exportXmlCurrUser(File file) {
        XML.exportXmlUser(session.getCurrentUser(), file);
    }

    public void exportToJson(File file) {
        JSON.exportToJson(session.getCurrentUser(), file);
    }

    public User getCurrUser() {
        return currUser;
    }

    public void setCurrUser(User currUser) {
        this.currUser = currUser;
    }




    public Session getSession() {
        return session;
    }

}
