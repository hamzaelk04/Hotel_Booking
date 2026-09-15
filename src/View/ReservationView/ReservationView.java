package View.ReservationView;

import View.ClientView;
import exception.InvalidCredentialException;
import exception.InvalidReservationDateException;
import exception.RoomNotFoundException;
import model.Reservation;
import model.Room;
import model.enums.ReservationStatus;
import model.enums.RoomStatus;
import service.AuthService;
import service.ReservationService;
import service.RoomService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ReservationView {
    public static void CreateReservation(AuthService authService, RoomService roomService, ReservationService reservationService) throws RoomNotFoundException, InvalidCredentialException, InvalidReservationDateException {
        if (!authService.isAuthenticated()) return;
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

        if (!authService.isAuthenticated()) throw new InvalidCredentialException();

        UUID userId = authService.getCurrentUser().getId();

        System.out.println("Enter the room number which you want:");
        String roomNumber = scanner.nextLine();

        Room room = roomService.searchByNumber(roomNumber).orElseThrow(RoomNotFoundException::new);

        System.out.println("Enter the start date: ");
        LocalDate checkIn = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter the end date: ");
        LocalDate checkOut = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter the number of guests: ");
        int numberOfGuests = scanner.nextInt();

        Reservation reservation = new Reservation(userId,
                roomNumber,
                checkIn,
                checkOut,
                numberOfGuests,
                reservationService.totalPrice(room.getPricePerNight(), checkIn, checkOut),
                ReservationStatus.CONFIRMED);

        reservationService.createReservation(reservation);

        System.out.println("Reservation registered.");
        System.out.println("Press enter to return:");
        String input = scanner.nextLine();

        if (input.isBlank()) ClientView.ClientMenu(authService, roomService, reservationService);
    }

    public static void ShowAllReservation(AuthService authService, ReservationService reservationService) {
        System.out.println(reservationService.
                showReservations(authService.
                        getCurrentUser().
                        getId()));;
    }
}
