package by.epam.demothreads.exercise12;

import static java.util.Objects.requireNonNull;
import java.util.List;

class Producer implements Runnable {
    private final List<String> data;

    Producer(List<String> data) {
        this.data = requireNonNull(data);
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            synchronized (data) {
                if (data.size() < 5) {
                    counter++;
                    data.add("writing:: " + counter);
                } else {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }
    }
}
