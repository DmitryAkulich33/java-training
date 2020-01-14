package by.epam.exercise04.service.exception;

public class InvalidPathException extends RuntimeException {
    public InvalidPathException() {
    }

    public InvalidPathException(String message) {
        super(message);
    }

    public InvalidPathException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPathException(Throwable cause) {
        super(cause);
    }
}
