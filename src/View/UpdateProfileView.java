package View;

import exception.InvalidCredentialException;
import model.User;
import service.AuthService;

import java.util.Scanner;

public class UpdateProfileView {
    public static void updateProfileMenu(AuthService authService) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        System.out.println("Hello " + authService.getCurrentUser().getName() + ".");

        System.out.println("Enter the new name: ");
        System.out.println("========================\n");
        String name = scanner.nextLine();

        while (name == null || name.isBlank()) {
            System.out.println("Enter a valid name: ");
            name = scanner.nextLine();
        }

        System.out.println("Enter the new email: ");
        System.out.println("========================\n");
        String email = scanner.nextLine();

        while (email == null || email.isBlank() || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Enter a valid email: ");
            email = scanner.nextLine();
        }

        System.out.println("Enter the new number phone: ");
        System.out.println("========================\n");
        String numberPhone = scanner.nextLine();

        while (!numberPhone.matches("\\d{10}")) {
            System.out.println("Enter a valid phone number: ");
            numberPhone = scanner.nextLine();
        }

        try {
            authService.updateProfile(authService.getCurrentUser().getId(), name, email, numberPhone);

            System.out.println(authService.getCurrentUser());
            System.out.println("Profile updated successfully");
        } catch (InvalidCredentialException e) {
            System.out.println(e);
        }
    }
}
