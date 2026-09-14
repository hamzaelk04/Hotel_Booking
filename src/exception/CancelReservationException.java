package exception;

public class CancelReservationException extends RuntimeException {
    public CancelReservationException() {
        super("You can not cancel this reservation");
    }
}
