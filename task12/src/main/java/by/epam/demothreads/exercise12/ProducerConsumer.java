package by.epam.demothreads.exercise12;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) {
        List<String> data = new LinkedList<>();
        Thread t1 = new Thread(new Producer(data));
        Thread t2 = new Thread(new Consumer(data));
        t1.start();
        t2.start();
    }
}
