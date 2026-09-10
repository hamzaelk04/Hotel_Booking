package View;

import exception.InvalidCredentialException;
import service.AuthService;

import java.util.Scanner;
import java.util.UUID;

public class UpdatePasswordView {
    public static void updatePasswordView(AuthService authService) throws InvalidCredentialException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        System.out.println("Hello " + authService.getCurrentUser().getName() + ".");

        System.out.println("Enter the old password: ");
        System.out.println("========================\n");
        String password = scanner.nextLine();

        while (password.length() < 6) {
            System.out.println("Enter a valid password: ");
            password = scanner.nextLine();
        }

        while (!authService.getCurrentUser().getPassword().equals(password)) {
            System.out.println("Incorrect password try again or press enter to exit: ");
            password = scanner.nextLine();

            if (password.isBlank()) {
                ClientView.ClientMenu(authService);
                return;
            }
        }

        System.out.println("Enter the old password: ");
        System.out.println("========================\n");
        String newPassword = scanner.nextLine();

        while (newPassword.length() < 6) {
            System.out.println("Enter a valid new password: ");
            newPassword = scanner.nextLine();
        }

        authService.updatePassword(authService.getCurrentUser().getId(), newPassword);
    }
}
