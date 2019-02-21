package patterns.adapter;

public class TurkeyAdapterToDuckUse {
    public static void main(String[] args) {
        DuckSound turkeyAdaptedToDuck = new TurkeyAdapterToDuck(new Turkey());
        turkeyAdaptedToDuck.DuckSound();
    }
}
