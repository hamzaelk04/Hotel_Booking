package service;

import exception.CancelReservationException;
import exception.InvalidReservationDateException;
import exception.ReservationNotFoundException;
import exception.RoomNotFoundException;
import model.Reservation;
import model.Room;
import model.enums.ReservationStatus;
import repository.ReservationRepository;
import repository.RoomRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public void createReservation(Reservation reservation) throws InvalidReservationDateException, RoomNotFoundException {
        roomRepository.findByRoomNumber(reservation.getRoomNumber()).orElseThrow(RoomNotFoundException::new);

        if (checkAvailability(reservation)) {
            throw new InvalidReservationDateException();
        }

        reservationRepository.save(reservation);
    }

    public boolean checkAvailability(Reservation reservation) throws InvalidReservationDateException {
        if (!reservation.getCheckOut().isBefore(reservation.getCheckOut())) {
            throw new InvalidReservationDateException();
        }

        List<Reservation> reservations = reservationRepository.findAll();

        for (Reservation existing : reservations) {
            if (reservation.getId() != null && reservation.getId().equals(existing.getId())) continue;

            if (!reservation.getRoomNumber().equals(existing.getRoomNumber())) continue;

            boolean overlap = reservation.getCheckIn().isBefore(existing.getCheckOut())
                    && reservation.getCheckOut().isAfter(existing.getCheckIn());

            if (overlap) return true;
        }

        return false;
    }

    public long numberOfNights(LocalDate checkIn, LocalDate checkOut) {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public BigDecimal totalPrice(BigDecimal PricePerNight, LocalDate checkIn, LocalDate checkOut) {

        return PricePerNight.multiply(BigDecimal.valueOf(numberOfNights(checkIn, checkOut)));
    }

    public void updateReservation(String reservationCode,
                                  String roomNumber,
                                  LocalDate checkIn,
                                  LocalDate checkOut,
                                  int numberOfGuests)
            throws ReservationNotFoundException, RoomNotFoundException, InvalidReservationDateException {

        Reservation reservation = reservationRepository.findByCode(reservationCode).orElseThrow(ReservationNotFoundException::new);

        Room room = roomRepository.findByRoomNumber(roomNumber).orElseThrow(RoomNotFoundException::new);

        long numberOfNights = ChronoUnit.DAYS.between(checkIn, checkOut);

        reservation.setRoomNumber(roomNumber);
        reservation.setCheckIn(checkIn);
        reservation.setCheckOut(checkOut);
        reservation.setNumberOfGuests(numberOfGuests);
        reservation.setNumberOfNights(numberOfNights);
        reservation.setTotalPrice(room.getPricePerNight());

        if (checkAvailability(reservation)) {
            throw new InvalidReservationDateException();
        }

        reservationRepository.save(reservation);
    }

//annuler une réservation
    public void cancelReservation(Reservation reservation) {
        if (reservation.getStatus().equals(ReservationStatus.COMPLETED)) throw new CancelReservationException();
        if (reservation.getStatus().equals(ReservationStatus.CANCELLED)) throw new CancelReservationException();

        reservation.setStatus(ReservationStatus.CANCELLED);
    }

//consulter les réservations du client
    
}