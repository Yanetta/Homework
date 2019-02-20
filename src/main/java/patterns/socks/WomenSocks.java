package patterns.socks;

public class WomenSocks extends SocksClass {

    String differency;


    public WomenSocks(String color, int size, String differency) {
        super(color, size);
        this.differency = differency;
    }

    public String getDifferency() {
        return differency;
    }

    public void setDifferency(String differency) {
        this.differency = differency;
    }

    @Override
    public String toString() {
        return "WomenSocks{" +
                "differency='" + differency + '\'' +
                '}';
    }
}
