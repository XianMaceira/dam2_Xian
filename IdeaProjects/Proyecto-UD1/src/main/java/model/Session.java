package model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
    private User currentUser;

    public Session(User currentUser) {
        this.currentUser = currentUser;
    }


    public void login(String user, String pass) {
        if (currentUser == null) {
            // Verificar las credenciales (user y pass) y, si son correctas, establecer currentUser
            if ("admin".equals(user) && "admin".equals(pass)) {
                currentUser = new User("admin", "admin", 0, "admin@admin");
                logSessionEvent("LOGIN");
            }
        }
    }

    public void logout() {
        if (currentUser != null) {
            logSessionEvent("LOGOUT");
            currentUser = null;
        }
    }

    private void logSessionEvent(String eventType) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());

        try (FileWriter writer = new FileWriter("session.log", true)) {
            writer.write(timestamp + " " + currentUser.getName() + " " + eventType + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
