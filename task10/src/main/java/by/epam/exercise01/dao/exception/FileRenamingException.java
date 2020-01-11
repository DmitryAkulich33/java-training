package by.epam.exercise01.dao.exception;

public class FileRenamingException extends RuntimeException {
    public FileRenamingException() {
    }

    public FileRenamingException(String message) {
        super(message);
    }

    public FileRenamingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileRenamingException(Throwable cause) {
        super(cause);
    }
}
