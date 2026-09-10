package exception;

public class InvalidCredentialException extends Exception{
    public InvalidCredentialException() {
        super("Invalid Credential Problem!");
    }
}