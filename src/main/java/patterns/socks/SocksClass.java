package patterns.socks;

public class SocksClass implements Socks {
    private String color;
    private int size;

    public SocksClass(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setSize(int size) {
        this.size = size;

    }

    @Override
    public void setColor(String color) {
        this.color = color;

    }

    @Override
    public String toString() {
        return "SocksClass{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
