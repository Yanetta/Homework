package patterns.abstractFactory;

public class FactoriesUse {
    public static void main(String[] args) {
        AbstractFactory chanelFactory = FactoryGenerator.getFactory("Chanel");

        ChanelBrand chanelDeodorant = chanelFactory.getChannelParfum("Chanel deodorant");
        chanelDeodorant.produceChanelParfum();
        ChanelBrand chanelEauDeToilette = chanelFactory.getChannelParfum("Chanel eau de toilette");
        chanelEauDeToilette.produceChanelParfum();

        AbstractFactory versacheFactory = FactoryGenerator.getFactory("Versache");
        VersacheBrand versacheDeodorant = versacheFactory.getVersacheParfum("Versache deodorant");
        versacheDeodorant.produceVersacheParfum();
        VersacheBrand versacheEauDeToilette = versacheFactory.getVersacheParfum("Versache eau de toilette");
        versacheEauDeToilette.produceVersacheParfum();
    }
}
