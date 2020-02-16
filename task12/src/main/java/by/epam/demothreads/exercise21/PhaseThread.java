package by.epam.demothreads.exercise21;

import java.util.concurrent.Phaser;

public class PhaseThread implements Runnable {
    Phaser phaser;
    String name;

    PhaseThread(Phaser p, String n) {

        this.phaser = p;
        this.name = n;
        phaser.register();
    }

    public void run() {

        System.out.println(name + " выполняетфазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, чтоперваяфазадостигнута

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, чтовтораяфазадостигнута

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister(); // сообщаем о завершениифаз и удаляем с регистрацииобъекты
    }

}
