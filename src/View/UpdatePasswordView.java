package View;

import exception.InvalidCredentialException;
import service.AuthService;
import service.RoomService;

import java.util.Scanner;
import java.util.UUID;

public class UpdatePasswordView {
    public static void updatePasswordView(AuthService authService, RoomService roomService) throws InvalidCredentialException {
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
                ClientView.ClientMenu(authService, roomService);
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

        try {
            authService.updatePassword(authService.getCurrentUser().getId(), newPassword);

            System.out.println("The password updated successfully");

            System.out.println("========================\n");
            System.out.println("Press enter to continue");
            String set = scanner.nextLine();

            if (set.isBlank()) {
                ClientView.ClientMenu(authService, roomService);
            }
        } catch (InvalidCredentialException e) {
            throw new RuntimeException(e);
        }
    }
}
