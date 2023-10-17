package model;

import java.util.HashMap;

public class Users {
    private HashMap<String, User> users;

    public Users() {
        users = new HashMap<>();
    }

    // Agregar user
    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    // Usuario por nombre
    public User getUserByName(String name) {
        return users.get(name);
    }

    // Lista completa
    public HashMap<String, User> getUsers() {
        return users;
    }

}
