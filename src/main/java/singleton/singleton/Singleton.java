package singleton.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {

            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }

        }
        return instance;
    }
}