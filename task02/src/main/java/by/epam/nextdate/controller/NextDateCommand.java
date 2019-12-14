package by.epam.nextdate.controller;

import by.epam.nextdate.domain.Date;
import by.epam.nextdate.exception.WrongDateException;
import by.epam.nextdate.scanner.ReadDate;

import java.util.List;

public class NextDateCommand {
    public void exec() throws WrongDateException{
        ReadDate readDate = new ReadDate();
        List<Integer> readNumbers = readDate.read();
        DateCreator dateCreator = new DateCreator();
        Date date = dateCreator.create(readNumbers);
        printCurrentDate(date);
        Date nextDate = calculateNextDate(date);
        printNextDate(nextDate);
    }

    public Date calculateNextDate(Date date){
        Date nextDate;
        int maxDays[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(date.isLeap()){
            maxDays[1] = 29;
        }
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        day++;
        if(day > maxDays[month - 1]){
            day = 1;
            month++;
            if(month > 12){
                month = 1;
                year++;
            }
            nextDate = new Date(day, month, year);
        } else {
            nextDate = new Date(day, month, year);
        }
        return nextDate;
    }

    public void printCurrentDate(Date date){
        if(date.getMonth() < 10){
            if(date.getDay() < 10) {
                System.out.println("The current date is 0" + date.getDay() + ".0" + date.getMonth() + "." + date.getYear());
            } else {
                System.out.println("The current date is " + date.getDay() + ".0" + date.getMonth() + "." + date.getYear());
            }
        } else {
            if(date.getDay() < 10) {
                System.out.println("The current date is 0" + date.getDay() + "." + date.getMonth() + "." + date.getYear());
            } else {
                System.out.println("The current date is " + date.getDay() + "." + date.getMonth() + "." + date.getYear());
            }
        }
    }

    public void printNextDate(Date nextDate){
        if(nextDate.getMonth() < 10){
            if(nextDate.getDay() < 10) {
                System.out.println("The next date is 0" + nextDate.getDay() + ".0" + nextDate.getMonth() + "." + nextDate.getYear());
            } else {
                System.out.println("The next date is " + nextDate.getDay() + ".0" + nextDate.getMonth() + "." + nextDate.getYear());
            }
        } else {
            if(nextDate.getDay() < 10) {
                System.out.println("The next date is 0" + nextDate.getDay() + "." + nextDate.getMonth() + "." + nextDate.getYear());
            } else {
                System.out.println("The next date is " + nextDate.getDay() + "." + nextDate.getMonth() + "." + nextDate.getYear());
            }
        }
    }
}
