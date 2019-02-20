package patterns.socks;

public class JustinTrudoSocks extends SocksClass {

    int beauty;

    public JustinTrudoSocks(String color, int size, int beauty) {
        super(color, size);
        this.beauty = beauty;
    }

    public int getBeauty() {
        return beauty;
    }

    public void setBeauty(int beauty) {
        this.beauty = beauty;
    }

    @Override
    public String toString() {
        return "JustinTrudoSocks{" +
                "beauty=" + beauty +
                '}';
    }
}
