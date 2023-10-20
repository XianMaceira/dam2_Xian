package model;

import java.io.Serializable;
import org.mindrot.jbcrypt.BCrypt;

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

    public class PassHashGen {
        public static String PassHashGen(String passwd) {
            return BCrypt.hashpw(passwd, BCrypt.gensalt());
        }
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", email=" + email + "]";
    }
}
