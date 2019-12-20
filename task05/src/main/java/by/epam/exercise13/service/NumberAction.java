package by.epam.exercise13.service;

import by.epam.exercise13.service.exception.WrongDataException;

public class NumberAction {
    public int getCount(int startValue, int endValue, int number) {
        if (startValue > endValue || number == 0) {
            throw new WrongDataException("The data is wrong");
        }
        int counter = 0;
        for (int i = startValue; i <= endValue; i++) {
            if (i % number == 0) {
                counter++;
            }
        }
        return counter;
    }
}
