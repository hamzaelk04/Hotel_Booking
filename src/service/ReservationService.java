package service;

import exception.InvalidReservationDateException;
import model.Reservation;
import repository.ReservationRepository;
import repository.impl.InMemoryReservationRepository;

import java.util.List;

public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //créer une réservation
//vérifier la disponibilité
//calculer le nombre de nuits
//calculer le prix total
//modifier une réservation
//annuler une réservation
//consulter les réservations du client
    public void createReservation(Reservation reservation) throws InvalidReservationDateException {
        if (!checkAvailability(reservation)) {
            throw new InvalidReservationDateException();
        }

        reservationRepository.save(reservation);
    }

    public boolean checkAvailability(Reservation reservation) {
        List<Reservation> reservations = reservationRepository.findAll();

        for (Reservation existing : reservations) {
            if (reservation.getId() != null && reservation.getId().equals(existing.getId())) continue;

            if (!reservation.getRoomNumber().equals(existing.getRoomNumber())) continue;

            boolean overlap = reservation.getCheckIn().isBefore(existing.getCheckOut())
                    && reservation.getCheckOut().isAfter(existing.getCheckIn());

            if (overlap) return false;
        }

        return true;
    }
}