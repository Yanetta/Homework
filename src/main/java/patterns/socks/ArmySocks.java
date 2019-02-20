package patterns.socks;

public class ArmySocks extends SocksClass {

    int quality;

    public ArmySocks(String color, int size, int quality) {
        super(color, size);
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "ArmySocks{" +
                "quality=" + quality +
                '}';
    }
}
