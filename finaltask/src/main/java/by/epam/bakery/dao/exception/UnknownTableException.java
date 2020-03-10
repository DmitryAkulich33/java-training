package by.epam.bakery.dao.exception;

public class UnknownTableException extends Exception {
    public UnknownTableException() {
    }

    public UnknownTableException(String message) {
        super(message);
    }

    public UnknownTableException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownTableException(Throwable cause) {
        super(cause);
    }
}
