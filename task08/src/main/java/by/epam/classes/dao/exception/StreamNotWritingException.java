package by.epam.classes.dao.exception;

public class StreamNotWritingException extends RuntimeException {
    String message;

    public StreamNotWritingException() {
    }

    public StreamNotWritingException(String message) {
        super(message);
    }

    public StreamNotWritingException(String message, Throwable cause) {
        super(message, cause);
    }

    public StreamNotWritingException(Throwable cause) {
        super(cause);
    }
}

