package by.epam.multithreading.ex01.service.parser;

import by.epam.multithreading.ex01.dao.exception.StreamNotReadingException;
import by.epam.multithreading.ex01.dao.impl.ReaderDAOImpl;
import by.epam.multithreading.ex01.service.exception.ServiceException;
import by.epam.multithreading.ex01.service.exception.WrongArrayException;
import by.epam.multithreading.ex01.service.exception.WrongThreadCountException;
import by.epam.multithreading.ex01.service.validator.ArrayValidator;
import by.epam.multithreading.ex01.service.validator.NumberThreadsValidator;

import java.util.List;

public class LineParser {


    public int[][] returnTwoDimArray(List<String> lines) throws WrongArrayException {
        if(lines.isEmpty()){
            throw new WrongArrayException ("List is empty.");
        }
        int length = lines.size() - 1;
        int[][] array = new int[length][length];
        for(int i = 0; i < length; i++){
            array[i] = returnArray(lines.get(i));
        }
        if(checkLength(array) && checkDiagonal(array)){
            return array;
        } else {
            throw new WrongArrayException("Array is wrong.");
        }
    }

    public int[] returnArray(String line) throws WrongArrayException {
        ArrayValidator validator = new ArrayValidator();
        int[] array;
        if(validator.isLineValid(line)){
            String[] parts = line.split("\\s+");
            int length = parts.length;
            array = new int[length];
            for(int i = 0; i < length; i++){
                array[i] = Integer.parseInt(parts[i]);
            }
        } else {
            throw new WrongArrayException("Array is wrong.");
        }
        return array;
    }

    public boolean checkDiagonal(int[][] array) {
        int length = array.length;
        for(int i = 0; i < length; i++){
            if (array[i][i] != 0){
                return false;
            }
        }
        return true;
    }
    public boolean checkLength(int[][] array) throws WrongArrayException{
        if(array.length != array[array.length - 1].length){
            throw new WrongArrayException("Array is wrong.");
        }
        return true;
    }

    public int returnThreadCount(List<String> lines) throws WrongThreadCountException {
        NumberThreadsValidator validator = new NumberThreadsValidator();
        if(lines.isEmpty()){
            throw new WrongThreadCountException("List is empty.");
        }
        String lastLine = lines.get(lines.size() - 1);
        if(validator.isLineValid(lastLine)){
            return Integer.parseInt(lastLine);
        } else {
            throw new WrongThreadCountException("Wrong count of threads.");
        }
    }
}
