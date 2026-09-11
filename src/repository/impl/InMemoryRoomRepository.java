package repository.impl;

import model.Room;
import repository.RoomRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InMemoryRoomRepository implements RoomRepository {
    private HashMap<String, Room> rooms = new HashMap<>();

    @Override
    public void save(Room room) {
        rooms.put(room.getRoomNumber(), room);
    }

    @Override
    public Optional<Room> findByRoomNumber(String roomNumber) {
        return rooms.values().stream().filter(room -> room.getRoomNumber().equals(roomNumber)).findFirst();
    }

    @Override
    public List<Room> findAll() {
        return List.copyOf(rooms.values());
    }
}