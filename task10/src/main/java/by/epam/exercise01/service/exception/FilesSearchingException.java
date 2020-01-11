package by.epam.exercise01.service.exception;

public class FilesSearchingException extends RuntimeException {
    public FilesSearchingException() {
    }

    public FilesSearchingException(String message) {
        super(message);
    }

    public FilesSearchingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FilesSearchingException(Throwable cause) {
        super(cause);
    }
}
