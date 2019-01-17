package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Res res = new Res(0);
        ExecutorService ex = Executors.newFixedThreadPool(3);

        Thread thread1 = new Thread(new ResRun(res, "name1"));
        Thread thread2 = new Thread(new ResRun(res,"name2"));
        Thread thread3 = new Thread(new ResRun(res, "name3"));
        ex.execute(thread1);
        ex.execute(thread2);
        ex.execute(thread3);
        ex.shutdown();
    }
}
