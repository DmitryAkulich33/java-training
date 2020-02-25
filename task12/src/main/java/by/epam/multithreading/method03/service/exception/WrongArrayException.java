package by.epam.multithreading.method03.service.exception;

public class WrongArrayException extends Exception{
    public WrongArrayException() {
    }

    public WrongArrayException(String message) {
        super(message);
    }

    public WrongArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongArrayException(Throwable cause) {
        super(cause);
    }
}
