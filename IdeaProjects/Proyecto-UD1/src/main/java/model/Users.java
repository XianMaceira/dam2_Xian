package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class Users implements Serializable {
    private HashMap<String, User> users = new HashMap<>();



    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Collection<User> users = this.users.values();
        for (User user : users) {
            sb.append(user.toString()).append("\n");
        }
        return sb.toString();
    }

}
