package model;

import java.util.UUID;

public class User {
    protected UUID id = UUID.randomUUID();
    private String name;
    protected String email;
    private String phoneNumber;
    protected String password;
    protected String role;

    public User(String name, String email,String phoneNumber, String password, String role) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Role= '" + role + '\'' +
                '}';
    }
}