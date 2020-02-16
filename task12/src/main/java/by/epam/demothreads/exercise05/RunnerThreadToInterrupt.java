package by.epam.demothreads.exercise05;

public class RunnerThreadToInterrupt {
    public static void main(String[] args) {
        System.out.println("Главный поток начал работу...");
        ThreadToInterrupt myThread = new ThreadToInterrupt("MyThread");
        myThread.start();
        try {
            Thread.sleep(5000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
        System.out.println("Главный поток завершил работу...");
    }
}
