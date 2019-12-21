package by.epam.sort.service;

public class DoubleSelectionSorter {
    public int[] sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int max = array[i];
            int min = array[i];
            int minIndex = i;
            int maxIndex = i;
            for (int j = i + 1; j <= length - 1; j++) {
                if (max < array[j]) {
                    max = array[j];
                    maxIndex = j;
                }
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (maxIndex == i && minIndex != length - 1) {
                swap(array, length - 1, maxIndex);
                swap(array, i, minIndex);
            }
            if (minIndex == length - 1 && maxIndex != i) {
                swap(array, i, minIndex);
                swap(array, length - 1, maxIndex);
            }
            if (minIndex == length - 1 && maxIndex == i) {
                swap(array, length - 1, i);
            }
            if (minIndex != length - 1 && maxIndex != i) {
                swap(array, length - 1, maxIndex);
                swap(array, i, minIndex);
            }
            length--;
        }
        return array;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
