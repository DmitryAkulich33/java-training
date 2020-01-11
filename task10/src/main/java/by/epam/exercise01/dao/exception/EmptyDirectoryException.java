package by.epam.exercise01.dao.exception;

public class EmptyDirectoryException extends RuntimeException {
    public EmptyDirectoryException() {
    }

    public EmptyDirectoryException(String message) {
        super(message);
    }

    public EmptyDirectoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyDirectoryException(Throwable cause) {
        super(cause);
    }
}
