package by.epam.demothreads.exercise14_2;

public class PhilosopherRunner {
    public static void main(String[] args) {
        final int nCounter = 5;
        String[] names = {
                "Аристотель", "Пифагор", "Платон", "Сократ", "Цицерон", "Кафка", "Кант"
        };

        Thread[] philosophers = new Thread[nCounter];
        Round round = new Round(nCounter);
        for (int i = 0; i < nCounter; ++i) {
            philosophers[i] = new Thread(
                    new Philosopher(names[i], i, nCounter, round, 1000*(1+i))
            );
        }
        System.out.println("Раунд " + round.getRound());
        for (Thread th : philosophers) {
            th.start();
        }
    }
}
