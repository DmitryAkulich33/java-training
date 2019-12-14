package by.epam.nextdate.controller;

import by.epam.nextdate.domain.Date;
import by.epam.nextdate.exception.WrongDateException;
import by.epam.nextdate.validator.DateValidator;

import java.util.List;

public class DateCreator {
    public Date create(List<Integer> numbers) throws WrongDateException{
        if(numbers.size() == 3){
            int day = numbers.get(0);
            int month = numbers.get(1);
            int year = numbers.get(2);
            Date readedDate = new Date(day, month, year);
            DateValidator validator = new DateValidator();
            if(validator.isValid(readedDate)) {
                return readedDate;
            } else {
                throw new WrongDateException("The entered date is wrong");
            }
        } else {
            throw new WrongDateException("The entered date is wrong");
        }
    }
}
