package repository;

import exception.ReservationNotFoundException;
import model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository {
    void save(UUID id, Reservation reservation);

    void save(Reservation reservation);

    Optional<Reservation> findById(UUID id) throws ReservationNotFoundException;

    Optional<Reservation> findByCode(String code) throws ReservationNotFoundException;

    List<Reservation> findByUserId(UUID userId);

    List<Reservation> findByRoomNumber(String roomNumber);

    List<Reservation> findAll();
}