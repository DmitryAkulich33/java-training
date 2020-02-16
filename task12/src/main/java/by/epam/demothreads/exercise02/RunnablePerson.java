package by.epam.demothreads.exercise02;

public class RunnablePerson extends Person implements Runnable  {
    public RunnablePerson(String name) {
        super(name);
    }

    public void run() {
        for(int i = 0; i < 10; i++ ){
            System.out.println(getName() + ": Hello World");
        }
    }
}
