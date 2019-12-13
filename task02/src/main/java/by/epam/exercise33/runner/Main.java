package by.epam.exercise33.runner;

public class Main {
    public static void main(String[] args) {
        int password = 9583;
        checkThePassword(password);
    }

    public static void checkThePassword(int password) {
        if (password == 9583 || password == 1747) {
            printModuleABC();
        } else if (password == 3331 || password == 7922) {
            printModuleBC();
        } else if (password == 9455 || password == 8997) {
            printModuleC();
        } else {
            printInCorrectData();
        }
    }

    public static void printModuleABC() {
        System.out.println("The following base modules are available: A, B, C.");
    }

    public static void printModuleBC() {
        System.out.println("The following base modules are available: B, C.");
    }

    public static void printModuleC() {
        System.out.println("The following base modules are available: C.");
    }

    public static void printInCorrectData() {
        System.out.println("The password is wrong.");
    }
}
