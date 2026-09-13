package View.RoomsView;

import View.ClientView;
import exception.InvalidCredentialException;
import model.Room;
import model.RoomStatus;
import service.AuthService;
import service.RoomService;

import java.util.List;
import java.util.Scanner;

public class RoomsView {

    public static void DisplayAllRooms(RoomService roomService, AuthService authService) throws InvalidCredentialException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        List<Room> rooms = roomService.showAllRooms();

        for (Room room : rooms) {
            System.out.println(room.toString());
            System.out.println("----------------------------");
        }

        System.out.println("Put enter to return");
        String choice = scanner.nextLine();

        if (choice.isBlank() && authService.isAuthenticated()) {
            ClientView.ClientMenu(authService, roomService);
        }
    }

    public static void DisplayAvailableRooms(RoomService roomService, AuthService authService) throws InvalidCredentialException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        List<Room> rooms = roomService.showAllRooms();

        for (Room room : rooms) {
            if (room.getStatus().equals(RoomStatus.AVAILABLE)) {
                System.out.println(room.toString());
                System.out.println("----------------------------");
            }
        }

        System.out.println("Put enter to return");
        String choice = scanner.nextLine();

        if (choice.isBlank() && authService.isAuthenticated()) {
            ClientView.ClientMenu(authService, roomService);
        }
    }
}