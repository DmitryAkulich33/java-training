package by.epam.exercise18.service;

import java.util.List;

public class ArrayValidator {
    public boolean isValid(List<Integer> list) {
        int index1 = list.get(0);
        int index2 = list.get(1);
        int value1 = list.get(2);
        int value2 = list.get(3);
        if (index1 < 0 || index2 < 0) {
            return false;
        }
        if (value1 + value2 < 4 || value1 > 6 || value1 < 1 || value2 > 6 || value2 < 1) {
            return false;
        }
        if (index1 == index2) {
            return false;
        }
        if ((index1 == index2 + 3) || (index1 == index2 + 6) || (index1 == index2 + 9)) {
            if (value1 != value2) {
                return false;
            }
        }
        if ((index2 == index1 + 3) || (index2 == index1 + 6) || (index2 == index1 + 9)) {
            if (value1 != value2) {
                return false;
            }
        }
        return true;
    }
}
