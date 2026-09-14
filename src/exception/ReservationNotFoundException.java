package exception;

public class ReservationNotFoundException extends Exception{
    public ReservationNotFoundException() {
        super("The reservation is not found");
    }
}