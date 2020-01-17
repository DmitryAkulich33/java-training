package by.epam.exercise02.dao;

import by.epam.exercise02.dao.exception.StreamNotWritingException;
import by.epam.exercise02.domain.Payment;

public interface ProductsWriterDAO {
    void writeBillInFile(Payment payment, String path) throws StreamNotWritingException;
}
