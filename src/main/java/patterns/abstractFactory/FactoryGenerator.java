package patterns.abstractFactory;

public class FactoryGenerator {
    public static AbstractFactory getFactory (String factory){
        if (factory.equalsIgnoreCase("Chanel")) {
            return new ChanelFactory();
        }
        if (factory.equalsIgnoreCase("Versache")) {
            return new VersacheFactory();
        }
        return null;
    }
}
