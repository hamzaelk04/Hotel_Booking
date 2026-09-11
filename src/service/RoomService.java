package service;

import exception.RoomNotFoundException;
import exception.RoomUnvailableException;
import model.Room;
import model.RoomStatus;
import repository.RoomRepository;

import java.util.List;
import java.util.Optional;

public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> showAllRooms() {
        return roomRepository.findAll();
    }
//contrôler l'état des chambres
    public void occupyRoom(String roomNumber) throws RoomNotFoundException, RoomUnvailableException {
        Room room = roomRepository.findByRoomNumber(roomNumber).orElseThrow(RoomNotFoundException::new);

        if (room.getStatus() != RoomStatus.AVAILABLE) {
            throw new RoomUnvailableException();
        }

        room.setStatus(RoomStatus.OCCUPIED);

        roomRepository.save(room);
    }

    public Optional<Room> searchByNumber(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }
}