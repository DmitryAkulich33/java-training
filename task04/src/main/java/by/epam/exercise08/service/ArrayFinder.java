package by.epam.exercise08.service;

import by.epam.exercise08.exception.WrongDataException;

public class ArrayFinder {
    public int findMin(int array[]){
        int min = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public int findMax(int array[]){
        int max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public int findIndexMaxElem(int[] array){
        int max = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public int findOtherMaxElem(int[]array, int count){
        if(count > array.length){
            throw new WrongDataException("The count is wrong");
        }
        int indexMaxElem;
        int minElem = findMin(array);
        for(int i = 1; i < count; i++){
            indexMaxElem = findIndexMaxElem(array);
            array[indexMaxElem] = minElem;
        }
        return findMax(array);
    }

}
