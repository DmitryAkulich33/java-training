package by.epam.exercise33.runner;

public class Main {
    public static void main(String[] args) {
        int number = 1231;
        solve(number);
    }

    public static void solve(int number){
        int maximum = 0;
        while (number > 0) {
            if (number % 10 > maximum) {
                maximum = number % 10;
            }
            number = number / 10;
        }
        print(maximum);
    }

    public static void print(int maximum){
        System.out.println("The largest digit of the number is: " + maximum);
    }
}
