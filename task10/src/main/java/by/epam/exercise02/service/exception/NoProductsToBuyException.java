package by.epam.exercise02.service.exception;

public class NoProductsToBuyException extends Exception {
    public NoProductsToBuyException() {
    }

    public NoProductsToBuyException(String message) {
        super(message);
    }

    public NoProductsToBuyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoProductsToBuyException(Throwable cause) {
        super(cause);
    }
}
