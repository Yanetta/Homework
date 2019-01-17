package executors;

public class ResRun implements Runnable {
    private Res res;
    private String name;

    public ResRun(Res res, String name) {
        this.res = res;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "waiting");
            for (int i = 0; i < 5; i++) {
                res.incrememnt();
                System.out.println(name + ":" + res.getValue());
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " end work");

    }
}

