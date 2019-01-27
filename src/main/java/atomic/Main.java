package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        AtomicInteger ai = new AtomicInteger(0);
        Thread thread1 = new Thread(new AtResUse(ai, "name1"));
        Thread thread2 = new Thread(new AtResUse(ai, "name2"));
        Thread thread3 = new Thread(new AtResUse(ai, "name3"));

        ex.execute(thread1);
        ex.execute(thread2);
        ex.execute(thread3);
        ex.shutdown();
    }
}
