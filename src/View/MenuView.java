package View;

import service.AuthService;

import java.util.Scanner;

public class MenuView {
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.println("========================\n");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                RegisterView.registerMenu();
                break;
            case 2:
                LoginView.loginMenu();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
