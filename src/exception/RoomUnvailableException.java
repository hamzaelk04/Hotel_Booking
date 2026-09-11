package exception;

public class RoomUnvailableException extends Exception{
    public RoomUnvailableException() {
        super("Room is not available!");
    }
}