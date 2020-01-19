package by.epam.exercise04.service.exception;

public class WrongNumberException extends Exception {
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
