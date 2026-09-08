import View.MenuView;
import View.RegisterView;
import repository.UserRepository;
import repository.impl.InMemoryUserRepository;

public class Main {

    public static void main(String[] args) {
        MenuView.displayMenu();
        RegisterView check = new RegisterView();
        System.out.println(check.getUserRepository().findAll());
    }

}