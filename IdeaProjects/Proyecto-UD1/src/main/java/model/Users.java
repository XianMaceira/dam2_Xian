package model;

import java.util.HashMap;

public class Users {
    private HashMap<String, User> users = new HashMap<>();

    public Users() {
        User user = new User("admin", "admin", "0", "admin@admin");
        users.put(user.getName(), user);
    }

    public void addUser(User user) {
        if (user != null && user.getName() != null && !user.getName().isEmpty()) {
            users.put(user.getName(), user);
        }
    }

    // Obtener usuario por nombre
    public User getUserByName(String name) {
        return users.get(name);
    }


    // Eliminar usuario por nombre
    public void deleteUser(String name) {
        users.remove(name);
    }

    // Verificar si un usuario existe por nombre
    public boolean userExists(String name) {
        return users.containsKey(name);
    }

}
