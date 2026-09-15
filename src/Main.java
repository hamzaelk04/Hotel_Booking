import View.MenuView;
import repository.ReservationRepository;
import repository.RoomRepository;
import repository.UserRepository;
import repository.impl.InMemoryReservationRepository;
import repository.impl.InMemoryRoomRepository;
import repository.impl.InMemoryUserRepository;
import service.AuthService;
import service.ReservationService;
import service.RoomService;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        AuthService authService = new AuthService(userRepository);

        RoomRepository roomRepository = new InMemoryRoomRepository();
        RoomService roomService = new RoomService(roomRepository);

        ReservationRepository reservationRepository = new InMemoryReservationRepository();
        ReservationService reservationService = new ReservationService(reservationRepository, roomRepository);

        MenuView.displayMenu(authService, roomService, reservationService);
    }

}