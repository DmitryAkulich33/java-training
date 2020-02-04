package by.epam.composite.service.exception;

public class CompositeParseException extends Exception {
    public CompositeParseException() {
    }

    public CompositeParseException(String message) {
        super(message);
    }

    public CompositeParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompositeParseException(Throwable cause) {
        super(cause);
    }
}
