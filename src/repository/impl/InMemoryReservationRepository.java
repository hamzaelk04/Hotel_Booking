package repository.impl;

import exception.ReservationNotFoundException;
import model.Reservation;
import repository.ReservationRepository;

import java.util.*;

public class InMemoryReservationRepository implements ReservationRepository {
    private HashMap<UUID, Reservation> reservations;

    @Override
    public void save(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }

    @Override
    public Optional<Reservation> findById(UUID id) throws ReservationNotFoundException{
        Optional<Reservation> reservation = reservations.values()
                .stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();

        if (reservation.isEmpty()) {
            throw new ReservationNotFoundException();
        }
        return reservation;
    }

    @Override
    public Optional<Reservation> findByCode(String code) throws ReservationNotFoundException{
        Optional<Reservation> reservation = reservations.values()
                .stream()
                .filter(r -> r.getReservationCode().equals(code))
                .findFirst();

        if (reservation.isEmpty()) {
            throw new ReservationNotFoundException();
        }
        return reservation;
    }

    @Override
    public List<Reservation> findByUserId(UUID userId) {
        return reservations.values()
                .stream()
                .filter(r -> r.getUserId().equals(userId))
                .toList();
    }

    @Override
    public List<Reservation> findByRoomNumber(String roomNumber) {
        return reservations.values()
                .stream()
                .filter(r -> r.getRoomNumber().equals(roomNumber))
                .toList();
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(reservations.values());
    }
}