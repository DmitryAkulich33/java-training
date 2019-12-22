package by.epam.classes.dao.exception;

public class StreamNotReadingException extends RuntimeException {
    String message;

    public StreamNotReadingException() {
    }

    public StreamNotReadingException(String message) {
        super(message);
    }

    public StreamNotReadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public StreamNotReadingException(Throwable cause) {
        super(cause);
    }
}
