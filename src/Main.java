import View.MenuView;
import repository.RoomRepository;
import repository.UserRepository;
import repository.impl.InMemoryRoomRepository;
import repository.impl.InMemoryUserRepository;
import service.AuthService;
import service.RoomService;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        AuthService authService = new AuthService(userRepository);

        RoomRepository roomRepository = new InMemoryRoomRepository();
        RoomService roomService = new RoomService(roomRepository);

        MenuView.displayMenu(authService, roomService);
    }

}