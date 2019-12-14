package by.epam.recursion.runner;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        print(sumWithCycle(array));
        print(sumWithRecursion(array, 0));
    }

    public static int sumWithCycle(int[] array) {
        int length = array.length;
        int result = 0;
        for (int element : array) {
            result = result + element;
        }
        return result;
    }

    public static int sumWithRecursion(int[] array, int beginIndex) {
        if (beginIndex == array.length - 1) {
            return array[beginIndex];
        }
        return array[beginIndex] + sumWithRecursion(array, beginIndex + 1);
    }

    public static void print(int sum) {
        System.out.println("The sum of all elements is " + sum);
    }
}
