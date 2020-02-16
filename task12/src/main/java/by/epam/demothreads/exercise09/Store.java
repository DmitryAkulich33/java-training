package by.epam.demothreads.exercise09;

public class Store {
    int counter = 0; // счетчик товаров
    final int N = 5;//максимально допустимое число

    //синхронизированный метод для производителей
    synchronized int put() {
        if (counter <= N)//если товаро вменьше
        {
            counter++;//кладем товар
            System.out.println("склад имеет " + counter + " товар(ов)");
            return 1;//вслучае удачного выполнения возвращаем 1
        }
        return 0;//вслучае неудачного выполнения возвращаем 0
    }

    //метод для покупателей
    synchronized int get() {
        if (counter > 0)//если хоть один товар присутствует
        {
            counter--;//берем товар
            System.out.println("склад имеет " + counter + " товар(ов)");
            return 1;//вслучае удачного выполнения возвращаем 1
        }
        return 0;//вслучае неудачного выполнения возвращаем 0
    }
}
