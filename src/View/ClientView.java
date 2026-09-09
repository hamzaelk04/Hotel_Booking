package View;

import model.User;
import service.AuthService;

import java.util.Scanner;

public class ClientView {

    public static void ClientMenu(AuthService authService, User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        System.out.println("1. Search available rooms\n" +
                "2. View all rooms\n" +
                "3. Create reservation\n" +
                "4. My reservations\n" +
                "5. Reservation details\n" +
                "6. Update reservation\n" +
                "7. Cancel reservation\n" +
                "8. Update profile\n" +
                "9. Change password\n" +
                "10. Logout\n" +
                "0. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
//                update profile
                break;
            case 9:
//                update Password
                break;
            case 10:
//                logout
                authService.logout(user.getId());
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
