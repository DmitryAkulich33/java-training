package by.epam.demothreads.exercise02;

public class Runner {
    public static void main(String[] args) {
        RunnablePerson p1 = new RunnablePerson("Alice");
        Thread t1 = new Thread(p1);
        t1.setPriority(Thread.MIN_PRIORITY);
        RunnablePerson p2 = new RunnablePerson("Bob");
        Thread t2 = new Thread(p2);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        System.out.println("Main finished");
    }
}
