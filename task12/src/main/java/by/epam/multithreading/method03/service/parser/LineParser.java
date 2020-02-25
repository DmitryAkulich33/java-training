package by.epam.multithreading.method03.service.parser;

import by.epam.multithreading.method03.service.exception.WrongArrayException;
import by.epam.multithreading.method03.service.exception.WrongThreadCountException;
import by.epam.multithreading.method03.service.validator.ArrayValidator;
import by.epam.multithreading.method03.service.validator.NumberThreadsValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LineParser {
    private static Logger log = LogManager.getLogger(LineParser.class.getName());

    public AtomicInteger[][] returnTwoDimArray(List<String> lines) throws WrongArrayException {
        if (lines.isEmpty()) {
            log.error("List lines from file is empty");
            throw new WrongArrayException("List is empty.");
        }
        int length = lines.size() - 1;
        AtomicInteger[][] array = new AtomicInteger[length][length];
        for (int i = 0; i < length; i++) {
            array[i] = returnArray(lines.get(i));
        }
        if (checkLength(array) && checkDiagonal(array)) {
            return array;
        } else {
            log.error("Array is wrong.");
            throw new WrongArrayException("Array is wrong.");
        }
    }

    private AtomicInteger[] returnArray(String line) throws WrongArrayException {
        ArrayValidator validator = new ArrayValidator();
        AtomicInteger[] array;
        if (validator.isLineValid(line)) {
            log.info("Line from file is valid.");
            String[] parts = line.split("\\s+");
            int length = parts.length;
            array = new AtomicInteger[length];
            for (int i = 0; i < length; i++) {
                array[i] = new AtomicInteger(Integer.parseInt(parts[i]));
            }
        } else {
            log.error("Array is wrong.");
            throw new WrongArrayException("Array is wrong.");
        }
        return array;
    }

    private boolean checkDiagonal(AtomicInteger[][] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i][i].get() != 0) {
                log.error("Diagonal elements are not zero");
                return false;
            }
        }
        return true;
    }

    private boolean checkLength(AtomicInteger[][] array) throws WrongArrayException {
        if (array.length != array[array.length - 1].length) {
            log.error("Array is not square.");
            throw new WrongArrayException("Array is wrong.");
        }
        return true;
    }

    public int returnThreadCount(List<String> lines) throws WrongThreadCountException {
        NumberThreadsValidator validator = new NumberThreadsValidator();
        if (lines.isEmpty()) {
            log.error("List lines from file is empty.");
            throw new WrongThreadCountException("List is empty.");
        }
        String lastLine = lines.get(lines.size() - 1);
        if (validator.isLineValid(lastLine)) {
            log.info("Count of threads from file is valid.");
            return Integer.parseInt(lastLine);
        } else {
            log.error("Wrong count of threads.");
            throw new WrongThreadCountException("Wrong count of threads.");
        }
    }
}
