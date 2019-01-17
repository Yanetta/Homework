package semaphore;

import semaphore.Incrementing;
import semaphore.Resource;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(3);
        Resource res = new Resource(6);

        Thread thread1 = new Thread(new Incrementing(res,sem, "name1"));
        Thread thread2 = new Thread(new Incrementing(res,sem, "name2"));
        Thread thread3 = new Thread(new Incrementing(res,sem, "name3"));
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
