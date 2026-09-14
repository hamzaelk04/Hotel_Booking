package repository.impl;

import model.Room;
import model.enums.RoomStatus;
import model.enums.RoomType;
import repository.RoomRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InMemoryRoomRepository implements RoomRepository {
    private HashMap<String, Room> rooms = new HashMap<>();

    public InMemoryRoomRepository() {
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.put("101", new Room("101", RoomType.SINGLE, 1, new BigDecimal("750"), RoomStatus.AVAILABLE));
        rooms.put("102", new Room("102", RoomType.SINGLE, 1, new BigDecimal("750"), RoomStatus.OCCUPIED));
        rooms.put("103", new Room("103", RoomType.SINGLE, 1, new BigDecimal("800"), RoomStatus.RESERVED));

        rooms.put("201", new Room("201", RoomType.DOUBLE, 2, new BigDecimal("1200"), RoomStatus.AVAILABLE));
        rooms.put("202", new Room("202", RoomType.DOUBLE, 2, new BigDecimal("1250"), RoomStatus.OCCUPIED));
        rooms.put("203", new Room("203", RoomType.DOUBLE, 2, new BigDecimal("1300"), RoomStatus.MAINTENANCE));

        rooms.put("301", new Room("301", RoomType.SUITE, 4, new BigDecimal("2500"), RoomStatus.AVAILABLE));
        rooms.put("302", new Room("302", RoomType.SUITE, 4, new BigDecimal("2800"), RoomStatus.RESERVED));
        rooms.put("303", new Room("303", RoomType.SUITE, 3, new BigDecimal("2200"), RoomStatus.OCCUPIED));
        rooms.put("304", new Room("304", RoomType.SUITE, 4, new BigDecimal("3000"), RoomStatus.OUT_OF_SERVICE));
    }

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