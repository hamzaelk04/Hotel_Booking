package service;

import exception.RoomNotFoundException;
import exception.RoomUnvailableException;
import model.Room;
import model.enums.RoomStatus;
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

    public void markAsAvailable(String roomNumber) throws RoomNotFoundException {
        Room room = roomRepository.findByRoomNumber(roomNumber).orElseThrow(RoomNotFoundException::new);

        room.setStatus(RoomStatus.AVAILABLE);

        roomRepository.save(room);
    }

    public void markAsReserved(String roomNumber) throws RoomNotFoundException {
        Room room = roomRepository.findByRoomNumber(roomNumber).orElseThrow(RoomNotFoundException::new);

        room.setStatus(RoomStatus.RESERVED);

        roomRepository.save(room);
    }

    public void markInMaintenance(String roomNumber) throws RoomNotFoundException {
        Room room = roomRepository.findByRoomNumber(roomNumber).orElseThrow(RoomNotFoundException::new);

        room.setStatus(RoomStatus.MAINTENANCE);

        roomRepository.save(room);
    }

    public void markAsOutOfService(String roomNumber) throws RoomNotFoundException {
        Room room = roomRepository.findByRoomNumber(roomNumber).orElseThrow(RoomNotFoundException::new);

        room.setStatus(RoomStatus.OUT_OF_SERVICE);

        roomRepository.save(room);
    }

    public Optional<Room> searchByNumber(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }
}