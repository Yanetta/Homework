package patterns.adapter;

public class TurkeyAdapterToDuck implements DuckSound {
    private Turkey turkey = null;

    public TurkeyAdapterToDuck(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void DuckSound() {
        turkey.turkeySay();
    }
}
