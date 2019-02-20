package patterns.socks;

public class MenSocks extends SocksClass {
   private int hard;

    public MenSocks(String color, int size, int hard) {
        super(color, size);
        this.hard = hard;
    }

    public int getHard() {
        return hard;
    }

    public void setHard(int hard) {
        this.hard = hard;
    }

    @Override
    public String toString() {
        return "MenSocks{" +
                "hard=" + hard +
                '}';
    }
}
