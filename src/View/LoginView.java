package View;

import exception.EmailNotFoundException;
import exception.InvalidPasswordException;
import model.User;
import repository.UserRepository;
import repository.impl.InMemoryUserRepository;
import service.AuthService;

import java.util.Scanner;

public class LoginView {
    private static final UserRepository userRepository =
            new InMemoryUserRepository();

    private static final AuthService authService =
            new AuthService(userRepository);

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static void loginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        System.out.println("Enter the email: ");
        System.out.println("========================\n");
        String email = scanner.nextLine();

        while (email == null || email.isBlank() || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Enter a valid email: ");
            email = scanner.nextLine();
        }

        System.out.println("Enter the password: ");
        System.out.println("========================\n");
        String password = scanner.nextLine();

        while (password.length() < 6) {
            System.out.println("The password at least must have 6 charachters: ");
            password = scanner.nextLine();
        }

        try {
            User user = authService.login(email, password);

            if (user.getRole().equals("Client")) {
                ClientView.ClientMenu();
            }

            if (user.getRole().equals("Admin")) {

            }
        } catch (EmailNotFoundException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }

    }
}
