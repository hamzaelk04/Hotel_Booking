package model;

public class Client extends User{
    private String name;
    private String numberPhone;

    public Client (String email, String password) {
        super(email, password, false
        );
    }

    public String getName() {
        return name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }
}
