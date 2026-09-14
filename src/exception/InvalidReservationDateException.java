package exception;


public class InvalidReservationDateException extends Exception{
    public InvalidReservationDateException() {
        super("You cannot make a reservation in this date!");
    }
}