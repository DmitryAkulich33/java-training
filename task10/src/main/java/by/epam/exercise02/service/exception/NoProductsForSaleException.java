package by.epam.exercise02.service.exception;

public class NoProductsForSaleException extends Exception {
    public NoProductsForSaleException() {
    }

    public NoProductsForSaleException(String message) {
        super(message);
    }

    public NoProductsForSaleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoProductsForSaleException(Throwable cause) {
        super(cause);
    }
}
