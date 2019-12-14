package by.epam.nextdate.validator;


import by.epam.nextdate.domain.Date;

public class DateValidator {
    public Boolean isValid(Date date) {
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        if (year <= 0) {
            return false;
        }
        int notLeapYear = date.isLeap() ? 0 : 1;

        if (month <= 0 || month > 12) {
            return false;
        }
        if (day <= 0 || (month == 2 && day > daysInMonth[month - 1] - notLeapYear) ||
                (month != 2 && day > daysInMonth[month - 1])) {
            return false;
        }
        return true;
    }
}
