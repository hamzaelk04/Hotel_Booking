package model;

public class Client extends User{
    private String name;
    private String numberPhone;

    public Client (String name, String email,String numberPhone, String password) {
        super(email, password, false);

        this.name = name;
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }
}
