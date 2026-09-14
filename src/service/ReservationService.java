package service;

import exception.InvalidReservationDateException;
import model.Reservation;
import repository.ReservationRepository;
import repository.impl.InMemoryReservationRepository;

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
        return true;
    }
}