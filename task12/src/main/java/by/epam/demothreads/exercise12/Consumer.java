package by.epam.demothreads.exercise12;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class Consumer implements Runnable {
    private final List<String> data;

    Consumer(List<String> data) {
        this.data = requireNonNull(data);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (data) {
                if (data.size() > 0) {
                    System.out.println("reading:: " + data.get(data.size() - 1));
                    data.remove(data.size() - 1);
                }
                data.notify();
            }
        }
    }
}
