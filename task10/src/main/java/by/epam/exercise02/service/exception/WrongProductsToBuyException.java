package by.epam.exercise02.service.exception;

public class WrongProductsToBuyException extends Exception {
    public WrongProductsToBuyException() {
    }

    public WrongProductsToBuyException(String message) {
        super(message);
    }

    public WrongProductsToBuyException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongProductsToBuyException(Throwable cause) {
        super(cause);
    }
}
