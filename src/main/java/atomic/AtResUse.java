package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtResUse implements Runnable {
    private String name;
    private AtomicInteger ai;

    public AtResUse(AtomicInteger ai, String name) {
        this.ai = ai;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "waiting");
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ":" + ai.incrementAndGet());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " end work");
    }
}
