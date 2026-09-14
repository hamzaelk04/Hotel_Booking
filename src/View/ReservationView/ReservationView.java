package View.ReservationView;

import model.Reservation;
import service.AuthService;
import service.ReservationService;
import service.RoomService;

import java.util.Scanner;

public class ReservationView {
    public static void CreateReservation(AuthService authService, RoomService roomService, ReservationService reservationService) {
        if (!authService.isAuthenticated()) return;
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================\n");
        System.out.println("     HOTEL BOOKING   \n");
        System.out.println("========================\n");


    }
}
