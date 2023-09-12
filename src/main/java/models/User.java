package models;

public class User {
    String email;
    String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public User withPassword(String password) {
        this.password = password;
        return this;
    }
}
