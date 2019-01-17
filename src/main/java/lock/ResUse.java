package lock;

import java.util.concurrent.locks.Lock;

public class ResUse implements Runnable {

    private Resource res;
    private Lock lock;
    private String name;

    public ResUse(Resource res, Lock lock, String name) {
        this.res = res;
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "waiting");
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                res.incrememnt();
                System.out.println(name + ":" + res.getValue());
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " end work");
        lock.unlock();
    }
}
