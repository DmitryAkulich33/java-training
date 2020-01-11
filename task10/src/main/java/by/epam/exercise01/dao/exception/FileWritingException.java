package by.epam.exercise01.dao.exception;

public class FileWritingException extends RuntimeException {
    public FileWritingException() {
    }

    public FileWritingException(String message) {
        super(message);
    }

    public FileWritingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileWritingException(Throwable cause) {
        super(cause);
    }
}
