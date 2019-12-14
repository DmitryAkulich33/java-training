package by.epam.wordsnumbers.exception;

public class WrongNumberException extends RuntimeException {
    String message;

    public WrongNumberException() {
    }

    public WrongNumberException(String message) {
        super(message);
    }

    public WrongNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongNumberException(Throwable cause) {
        super(cause);
    }
}
