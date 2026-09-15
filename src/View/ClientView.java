package View;

import View.ReservationView.ReservationView;
import View.RoomsView.RoomsView;
import exception.InvalidCredentialException;
import exception.InvalidReservationDateException;
import exception.RoomNotFoundException;
import model.Reservation;
import service.AuthService;
import service.ReservationService;
import service.RoomService;

import java.util.Scanner;

public class ClientView {

    public static void ClientMenu(AuthService authService, RoomService roomService, ReservationService reservationService) throws InvalidCredentialException, RoomNotFoundException, InvalidReservationDateException {
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
                RoomsView.DisplayAvailableRooms(roomService, authService, reservationService);
                break;
            case 2:
                RoomsView.DisplayAllRooms(roomService, authService, reservationService);
                break;
            case 3:
                ReservationView.CreateReservation(authService, roomService, reservationService);
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
                UpdatePasswordView.updatePasswordView(authService, roomService, reservationService);
                break;
            case 10:
//                logout
                authService.logout(authService.getCurrentUser().getId());
                MenuView.displayMenu(authService, roomService, reservationService);
                break;
            case 0:
                MenuView.displayMenu(authService, roomService, reservationService);
            default:
                System.out.println("Invalid choice!");
        }
    }
}
