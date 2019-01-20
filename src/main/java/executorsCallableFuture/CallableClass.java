package executorsCallableFuture;

import java.util.concurrent.Callable;

public class CallableClass implements Callable <Resource> {
    private Resource res;
    private String name;

    public CallableClass (Resource res, String name) {
        this.res = res;
        this.name = name;
    }

    @Override
    public Resource call() throws InterruptedException {
        System.out.println(name + "waiting");
        for (int i = 0; i < 5; i++) {
            res.increment();
            System.out.println(name + ":" + res.getValue());
        }
        Thread.sleep(1000);
        System.out.println(name + " end work");
        return res;
    }
}
