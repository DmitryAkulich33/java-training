package by.epam.composite.dao.exception;

public class FileNotWritingException extends Exception {
    public FileNotWritingException() {
    }

    public FileNotWritingException(String message) {
        super(message);
    }

    public FileNotWritingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotWritingException(Throwable cause) {
        super(cause);
    }
}
