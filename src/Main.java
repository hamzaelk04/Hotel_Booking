import View.MenuView;
import repository.UserRepository;
import repository.impl.InMemoryUserRepository;
import service.AuthService;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        AuthService authService = new AuthService(userRepository);

        MenuView.displayMenu(authService);
    }

}