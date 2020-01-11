package by.epam.exercise01.dao.exception;

public class FileCreatingException extends RuntimeException {
    public FileCreatingException() {
    }

    public FileCreatingException(String message) {
        super(message);
    }

    public FileCreatingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileCreatingException(Throwable cause) {
        super(cause);
    }
}
