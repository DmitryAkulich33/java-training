package by.epam.exercise08.runner;

public class Main {
    public static void main(String[] args) {
        double lineStart = 15.0;
        double lineEnd = 30.0;
        double step = 2.0;
        double c = 1.0;
        solve(lineStart, lineEnd, step, c);

    }

    public static void print(double x, double y) {
        System.out.println("Function value: x = " + x + ", y = " + y);
    }

    public static void solve(double lineStart, double lineEnd, double step, double c) {
        double result;
        while (lineStart <= lineEnd) {
            if (lineStart == 15) {
                result = (lineStart + c) * 2;
                print(lineStart, result);
            } else {
                result = (lineStart - c) + 6;
                print(lineStart, result);
            }
            lineStart += step;
        }
    }
}
