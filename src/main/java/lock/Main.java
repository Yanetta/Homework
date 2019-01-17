package lock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Resource res = new Resource(6);

        Thread thread1 = new Thread(new ResUse(res, lock, "name1"));
        Thread thread2 = new Thread(new ResUse(res, lock, "name2"));
        Thread thread3 = new Thread(new ResUse(res, lock, "name3"));
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

