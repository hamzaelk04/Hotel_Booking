package model;

import java.util.UUID;

public class User {
    protected UUID id = UUID.randomUUID();
    private String name;
    protected String email;
    private String numberPhone;
    protected String password;
    protected String role;

    public User(String name, String email,String numberPhone, String password, String role) {
        this.name = name;
        this.email = email;
        this.numberPhone = numberPhone;
        this.password = password;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() { return role; }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Client{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", Role= '" + role + '\'' +
                '}';
    }
}