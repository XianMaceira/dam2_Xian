package model;

import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    private String age;
    private String email;

    public User(String name, String password, String age, String email) {
        this.name = name;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(10));
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
        return password;
    }

    public void setPasswordHash(String passwordHash) {
        this.password = passwordHash;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void checkLogin(String password) {

        String candidatePassword = password;


        if (BCrypt.checkpw(candidatePassword, password)) {
            System.out.println("La contraseña es válida");
        } else {
            System.out.println("La contraseña no es válida");
        }
    }


   /* public static String generateHash(String passwd) {

        // Generar un hash Bcrypt
        String hashedPassword = BCrypt.hashpw(passwd, BCrypt.gensalt(10));

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
    }*/


    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", email=" + email + "]";
    }
}
