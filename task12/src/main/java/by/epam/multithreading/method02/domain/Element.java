package by.epam.multithreading.method02.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

public class Element {
    private static Logger log = LogManager.getLogger(Element.class.getName());
    private Semaphore sem;
    private int value;
    private int x;
    private int y;

    public Element() {
    }

    public Element(Semaphore sem, int value, int x, int y) {
        this.sem = sem;
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public void lockElement() throws InterruptedException {
        log.info("Element is lock.");
        sem.acquire();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void unLock() {
        log.info("Element is unlock.");
        sem.release();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        if (value != element.value) return false;
        if (x != element.x) return false;
        if (y != element.y) return false;
        return sem != null ? sem.equals(element.sem) : element.sem == null;
    }

    @Override
    public int hashCode() {
        int result = sem != null ? sem.hashCode() : 0;
        result = 31 * result + value;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Element{" +
                "sem=" + sem +
                ", value=" + value +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
