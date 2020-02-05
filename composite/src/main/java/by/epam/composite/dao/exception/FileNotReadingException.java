package by.epam.composite.dao.exception;

public class FileNotReadingException extends Exception {
    public FileNotReadingException() {
    }

    public FileNotReadingException(String message) {
        super(message);
    }

    public FileNotReadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotReadingException(Throwable cause) {
        super(cause);
    }
}
