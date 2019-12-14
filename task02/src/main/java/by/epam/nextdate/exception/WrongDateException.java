package by.epam.nextdate.exception;

public class WrongDateException extends RuntimeException {
    String message;

    public WrongDateException() {
    }

    public WrongDateException(String message) {
        super(message);
    }

    public WrongDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDateException(Throwable cause) {
        super(cause);
    }
}
