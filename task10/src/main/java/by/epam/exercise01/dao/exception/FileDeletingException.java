package by.epam.exercise01.dao.exception;

public class FileDeletingException extends Exception {
    public FileDeletingException() {
    }

    public FileDeletingException(String message) {
        super(message);
    }

    public FileDeletingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileDeletingException(Throwable cause) {
        super(cause);
    }
}
