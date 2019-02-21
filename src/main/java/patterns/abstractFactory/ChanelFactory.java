package patterns.abstractFactory;

public class ChanelFactory extends AbstractFactory {
    @Override
    public ChanelBrand getChannelParfum(String parfum) {
        if (parfum == null) {
            return null;
        }
        if (parfum.equalsIgnoreCase("Chanel deodorant")) {
            return new ChanelDeodorant();
        }
        if (parfum.equalsIgnoreCase("Chanel eau de toilette")) {
            return new ChanelEauDeToilette();
        }
        return null;
    }

    @Override
    public VersacheBrand getVersacheParfum(String parfum) {
        return null;
    }
}
