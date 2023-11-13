package model;

import gui.*;
import org.mindrot.jbcrypt.BCrypt;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;
    private FileHandler fhandler;




    public App() throws IOException {
        session = new Session();
        fhandler = new FileHandler(filename);
        users = fhandler.load();
        showLoginWindow();
    }

    public boolean login(String userName, String passwd) {
        if (users.userExists(userName)) {
            User usuario = users.getUserByName(userName);
            //String hash = usuario.getPasswordHash();
            System.out.println(usuario);
            if(usuario.checkLogin(passwd)) {
                System.out.println("Logged in");
                session.setCurrentUser(users.getUserByName(userName));
                session.logSessionEvent("LOGIN");
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

    public void exportXmlCurrUser(File file) throws ParserConfigurationException {

        XML.exportXmlUser(session.getCurrentUser(), file);
    }

    public void exportToJson(File file) {
        JSON.exportToJson(session.getCurrentUser(), file);
    }

    public void showChangePasswordWindow() {
        UserChangePassword userChangePasswordWindow = new UserChangePassword(this, session.getCurrentUser().getName());
        userChangePasswordWindow.setVisible(true);
    }

    public void changePassword(String newPassword) {
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt(10));
        session.getCurrentUser().setPasswordHash(hashedPassword);
        fhandler.saveUsers(users);
    }

    public void closeSession() {
        session.logSessionEvent("LOGOUT");
        session.setCurrentUser(null);
        Login loginWindow = new Login(this);
        loginWindow.setVisible(true);
    }

    public Session getSession() {
        return session;
    }

    public void createUserWindow() {
        UserCreate createUserWindow = new UserCreate(this);
        createUserWindow.setVisible(true);
    }


    public void createUser(String name, String passwd, String age, String mail) {
        User newUser = new User(name, passwd, age, mail);
        users.addUser(newUser);
        fhandler.saveUsers(users);
    }

    public void deleteUserWindow() {
        UserDelete deleteUserWindow = new UserDelete(this, session.getCurrentUser().getName());
        deleteUserWindow.setVisible(true);
    }

    public void delUser() {
        users.deleteUser(session.getCurrentUser().getName());
        fhandler.saveUsers(users);
    }

    public void showUserWindow() {
        gui.User userWindow = new gui.User(this, session.getCurrentUser().getName());
        userWindow.setVisible(true);
    }
    public void showLoginWindow() {
        Login loginWindow = new Login(this);
        loginWindow.setVisible(true);
    }

    public void exportAllUsersToXML(File file) throws ParserConfigurationException {
        XML.exportAllUsersXML(users, file);
    }

    public void exportAllUsersToJSON(File file) {
        JSON.exportAllUsersJSON(users, file);
    }

    public void zipExport (File file) throws ParserConfigurationException, IOException {
        ZIP.exportAllUsersZip(this, file);
    }


}
