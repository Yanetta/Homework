package executors;

public class Res {
    private  int value = 0;

    public Res (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int incrememnt (){
        return value++;
    }
}
