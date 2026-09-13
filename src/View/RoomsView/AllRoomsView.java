package View.RoomsView;

import View.ClientView;
import exception.InvalidCredentialException;
import model.Room;
import service.AuthService;
import service.RoomService;

import java.util.List;
import java.util.Scanner;

public class AllRoomsView {
    static Scanner scanner = new Scanner(System.in);

    public static void DisplayAllRooms(RoomService roomService, AuthService authService) throws InvalidCredentialException {
        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");

        List<Room> rooms = roomService.showAllRooms();

        for (Room room : rooms) {
            System.out.println(room);
            System.out.println("----------------------------");
        }

        System.out.println("Put enter to return");
        String  choice = scanner.nextLine();

        if (choice.isBlank() && authService.isAuthenticated()) {
            ClientView.ClientMenu(authService, roomService);
        }
    }
}