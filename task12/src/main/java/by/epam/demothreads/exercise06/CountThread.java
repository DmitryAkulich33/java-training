package by.epam.demothreads.exercise06;

public class CountThread implements Runnable {
    CommonResource res;
    CountThread(CommonResource res){
        this.res=res;
    }

    public void run(){
        res.increment();
    }

}


