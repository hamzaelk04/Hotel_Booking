package View;

import exception.EmailAlreadyExistsException;
import model.Client;
import repository.UserRepository;
import repository.impl.InMemoryUserRepository;
import service.AuthService;

import java.util.Scanner;

public class RegisterView {
    private static final UserRepository userRepository =
            new InMemoryUserRepository();

    private static final AuthService authService =
            new AuthService(userRepository);

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    //    public RegisterView(AuthService authService) {
//        this.authService = authService;
//    }

    public static void registerMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        System.out.println("Enter the name: ");
        System.out.println("========================\n");
        String name = scanner.nextLine();

        while (name == null || name.isBlank()) {
            System.out.println("Enter a valid name: ");
            name = scanner.nextLine();
        }

        System.out.println("Enter the email: ");
        System.out.println("========================\n");
        String email = scanner.nextLine();

        while (email == null || email.isBlank() || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Enter a valid email: ");
            email = scanner.nextLine();
        }

        System.out.println("Enter the phone number: ");
        System.out.println("========================\n");
        String phoneNumber = scanner.nextLine();

        while (!phoneNumber.matches("\\d{10}")) {
            System.out.println("Enter a valid phone number: ");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("Enter the password: ");
        System.out.println("========================\n");
        String password = scanner.nextLine();

        while (password.length() < 6) {
            System.out.println("Enter a valid password: ");
            password = scanner.nextLine();
        }

        Client client = new Client(name, email, phoneNumber, password);


        try {
            authService.register(client);
            System.out.println("Registration successful!");
        } catch (EmailAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }
}
