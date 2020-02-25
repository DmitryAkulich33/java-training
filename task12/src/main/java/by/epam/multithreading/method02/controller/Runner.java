package by.epam.multithreading.method02.controller;

public class Runner {
    public static void main(String[] args) {
        Controller controller = new Controller();
        String path = "src\\main\\resources\\multi\\matrix.txt";
        controller.execute(path);
    }
}
