package model;

import java.util.UUID;

public class User {
    protected UUID id = UUID.randomUUID();
    protected String email;
    protected String password;
    protected boolean isAdmin;

    public User(String email, String password, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}