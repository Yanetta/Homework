package patterns.adapter;

public class Turkey implements TurkeySound {
    @Override
    public void turkeySay() {
        System.out.println("Yelp");
    }
}
