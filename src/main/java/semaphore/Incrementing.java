package semaphore;

import semaphore.Resource;

import java.util.concurrent.Semaphore;

public class Incrementing implements Runnable {
    private Resource res;
    private Semaphore sem;
    private String name;

    public Incrementing(Resource res, Semaphore sem, String name) {
        this.res = res;
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name + "waiting");
        try {
            sem.acquire();
            for (int i = 0; i < 5; i++) {
                res.incrememnt();
                System.out.println(name + ":" + res.getValue());
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " end work");
        sem.release();
    }
}