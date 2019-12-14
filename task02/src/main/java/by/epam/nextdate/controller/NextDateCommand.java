package by.epam.nextdate.controller;

import by.epam.nextdate.domain.Date;
import by.epam.nextdate.exception.WrongDateException;
import by.epam.nextdate.scanner.ReadDate;

import java.util.List;

public class NextDateCommand {
    public void exec() throws WrongDateException{
        ReadDate readDate = new ReadDate();
        List<Integer> readedNumbers = readDate.read();

        DateCreator dateCreator = new DateCreator();
        Date date = dateCreator.create(readedNumbers);
        printCurrentDate(date);


    }

    public Date calculteNextDate(Date date){
        int maxDays[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(date.isLeap()){
            maxDays[1] = 29;
        }
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        day++;
        

    }

    public void printCurrentDate(Date date){
        if(date.getMonth() < 10){
            System.out.println("The current date is " + date.getDay() + ".0" + date.getMonth() + "." + date.getYear());
        } else {
            System.out.println("The current date is " + date.getDay() + "." + date.getMonth() + "." + date.getYear());
        }
    }

    public void printNextDate(Date date){
        if(date.getMonth() < 10){
            System.out.println("The next date is " + date.getDay() + ".0" + date.getMonth() + "." + date.getYear());
        } else {
            System.out.println("The next date is " + date.getDay() + "." + date.getMonth() + "." + date.getYear());
        }
    }
}
