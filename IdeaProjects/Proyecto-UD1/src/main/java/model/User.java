package model;

import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String passwordHash;
    private int age;
    private String email;

    public User(String name, String passwordHash, int age, String email) {
        this.name = name;
        this.passwordHash = passwordHash;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static String generateHash(String passwd) {

        // Generar un hash Bcrypt
        String hashedPassword = BCrypt.hashpw(passwd, BCrypt.gensalt());

        // Imprimir el hash resultante
        System.out.println("Hash Bcrypt: " + hashedPassword);

        // Verificar una contraseña
        String candidatePassword = "abc";
        if (BCrypt.checkpw(candidatePassword, hashedPassword)) {
            System.out.println("La contraseña es válida");
        } else {
            System.out.println("La contraseña no es válida");
        }
        return hashedPassword;
    }


    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", email=" + email + "]";
    }
}
