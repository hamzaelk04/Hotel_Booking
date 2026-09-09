package exception;

public class EmailNotFoundException extends Exception{
    public EmailNotFoundException() {
        super("The email is not found!");
    }
}
