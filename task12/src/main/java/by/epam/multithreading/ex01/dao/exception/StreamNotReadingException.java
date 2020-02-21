package by.epam.multithreading.ex01.dao.exception;

public class StreamNotReadingException extends Exception {
    public StreamNotReadingException() {
    }

    public StreamNotReadingException(String message) {
        super(message);
    }

    public StreamNotReadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public StreamNotReadingException(Throwable cause) {
        super(cause);
    }
}
