package View;

import View.RoomsView.AllRoomsView;
import exception.InvalidCredentialException;
import model.User;
import service.AuthService;
import service.RoomService;

import java.util.Scanner;

public class ClientView {

    public static void ClientMenu(AuthService authService, RoomService roomService) throws InvalidCredentialException {
        if (!authService.isAuthenticated()) return;
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        System.out.println("""
                1. Search available rooms
                2. View all rooms
                3. Create reservation
                4. My reservations
                5. Reservation details
                6. Update reservation
                7. Cancel reservation
                8. Update profile
                9. Change password
                10. Logout
                0. Exit""");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                break;
            case 2:
                AllRoomsView.DisplayAllRooms(roomService, authService);
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
                UpdateProfileView.updateProfileMenu(authService);
                break;
            case 9:
//                update Password
                UpdatePasswordView.updatePasswordView(authService, roomService);
                break;
            case 10:
//                logout
                authService.logout(authService.getCurrentUser().getId());
                MenuView.displayMenu(authService, roomService);
                break;
            case 0:
                MenuView.displayMenu(authService, roomService);
            default:
                System.out.println("Invalid choice!");
        }
    }
}
