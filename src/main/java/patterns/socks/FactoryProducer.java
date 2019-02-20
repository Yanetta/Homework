package patterns.socks;

public abstract class FactoryProducer {
    public static AbstractSocksFactory getFactory(String var) {
        AbstractSocksFactory factory = null;
        if ("Kyiv".equals(var)) {
            factory = new KyivFactory();
        } else if ("Chineeze".equals(var)) {
            factory = new ChineezeFactory();
        }
        return factory;
    }
}
