package repository.impl;

import exception.ReservationNotFoundException;
import model.Reservation;
import repository.ReservationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryReservationRepository implements ReservationRepository {
    private HashMap<UUID, Reservation> reservations;

    @Override
    public void save(UUID id, Reservation reservation) {

    }

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
        return Optional.empty();
    }

    @Override
    public Optional<Reservation> findByCode(String code) {
        return Optional.empty();
    }

    @Override
    public List<Reservation> findByUserId(UUID userId) {
        return List.of();
    }

    @Override
    public List<Reservation> findByRoomNumber(String roomNumber) {
        return List.of();
    }

    @Override
    public List<Reservation> findAll() {
        return List.of();
    }
}