package patterns.abstractFactory;

public class VersacheFactory extends AbstractFactory {

    @Override
    public ChanelBrand getChannelParfum(String parfum) {
        return null;
    }

    @Override
    public VersacheBrand getVersacheParfum(String parfum) {
        if (parfum == null) {
            return null;
        }
        if (parfum.equalsIgnoreCase("Versache deodorant")) {
            return new VersacheDeodorant();
        }
        if (parfum.equalsIgnoreCase("Versache eau de toilette")) {
            return new VersacheEauDeToilette();
        }
        return null;
    }
}
