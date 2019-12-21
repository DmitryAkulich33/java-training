package by.epam.sort.controller;

import by.epam.sort.service.*;
import by.epam.sort.view.ArrayViewer;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] array = {13, 6, 4, 2, 8, 7, 1};
        ArrayViewer arrayViewer = new ArrayViewer();
        arrayViewer.printArray(array);
        DoubleSelectionSorter doubleSelectionSort = new DoubleSelectionSorter();
        SelectionSorter selectionSorter = new SelectionSorter();
        arrayViewer.printArray(doubleSelectionSort.sort(Arrays.copyOf(array, array.length)));
        arrayViewer.printArray(selectionSorter.sort(Arrays.copyOf(array, array.length)));
        BubbleSorter bubbleSorter = new BubbleSorter();
        arrayViewer.printArray(bubbleSorter.sort(Arrays.copyOf(array, array.length)));
        InsertionSorter insertionSorter = new InsertionSorter();
        arrayViewer.printArray(insertionSorter.sort(Arrays.copyOf(array, array.length)));
        ShekerSorter shekerSorter = new ShekerSorter();
        arrayViewer.printArray(shekerSorter.sort(Arrays.copyOf(array, array.length)));
        ShellSorter shellSorter = new ShellSorter();
        arrayViewer.printArray(shellSorter.sort(Arrays.copyOf(array, array.length)));
    }
}
