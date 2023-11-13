package model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
    private User currentUser;


    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }
/*  public void login(String user, String pass) {
        if (currentUser == null) {
            if ("admin".equals(user) && "admin".equals(pass)) {
                currentUser = new User("admin", "admin", "0", "admin@admin");
                logSessionEvent("LOGIN");
            }
        }
    }*/


  /*  public void logout() {
        if (currentUser != null) {
            logSessionEvent("LOGOUT");
            currentUser = null;
        }
    }*/

    public void logSessionEvent(String eventType) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = format.format(new Date());

        try (FileWriter writer = new FileWriter("session.log", true)) {
            writer.write(timestamp + " " + currentUser.getName() + " " + eventType + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
