package executorsCallableFuture;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Resource res = new Resource(0);
        ExecutorService ex = Executors.newFixedThreadPool(3);

        FutureTask<Resource> f1 =new FutureTask<Resource>(new CallableClass(res, "name1"));
        FutureTask<Resource> f2 =new FutureTask<Resource>(new CallableClass(res, "name2"));
        FutureTask<Resource> f3 =new FutureTask<Resource>(new CallableClass(res, "name3"));

        ex.submit(f1);
        ex.submit(f2);
        ex.submit(f3);

        try {
            System.out.println("The value is: " + f1.get().getValue());
            System.out.println("The value is: " + f2.get().getValue());
            System.out.println("The value is: " + f3.get().getValue());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        ex.shutdown();
    }
}