package View.AuthView;

import View.ClientView;
import exception.EmailNotFoundException;
import exception.InvalidCredentialException;
import exception.InvalidPasswordException;
import model.enums.UserRole;
import service.AuthService;
import service.RoomService;

import java.util.Scanner;

public class LoginView {

    public static void loginMenu(AuthService authService, RoomService roomService) {
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
            authService.login(email, password);

            if (authService.sessionManagement().equals(UserRole.CLIENT)) {
                ClientView.ClientMenu(authService, roomService);
            }

            if (authService.sessionManagement().equals(UserRole.ADMIN)) {

            }
        } catch (EmailNotFoundException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCredentialException e) {
            throw new RuntimeException(e);
        }

    }
}
