package by.epam.exercise23.runner;

public class Main {
    public static void main(String[] args) {
        double lineStart = 2.0;
        double lineEnd = 10.0;
        double step = 2.0;
        printTitleLine();
        solve(lineStart, lineEnd, step);
    }

    public static void solve(double lineStart, double lineEnd, double step) {
        while (lineStart <= lineEnd) {
            double result = (1.0 / Math.tan(lineStart / 3)) + (Math.sin(lineStart) / 2);
            printValues(lineStart, result);
            lineStart += step;
        }
    }

    public static void printTitleLine() {
        System.out.printf("%4s%10s%n", "x", "F(x)");
    }

    public static void printValues(double x, double y) {
        System.out.printf("%6.2f%8.2f%n", x, y);
    }
}
