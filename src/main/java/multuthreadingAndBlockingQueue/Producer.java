package multuthreadingAndBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class Producer implements Runnable {
    private BlockingQueue <Integer> bq;

    public Producer(BlockingQueue <Integer> queue) {
        this.bq = queue;
    }

    public void run() {
        Random rand = new Random();
        Integer res = 0;
        try {
            for (int i = 0; i < 10; i++) {
                res = rand.nextInt(10) * rand.nextInt(50);
                System.out.println("Produced: " + res);
                bq.put(res);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

