package executorsCallableFuture;

public class Resource {
    private  int value = 0;

    public Resource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int increment (){
        return value++;
    }
}
