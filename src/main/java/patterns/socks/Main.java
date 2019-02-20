package patterns.socks;

public class Main {

    public Socks createSocksByType(String type) {
        SocksClass socks = null;

        if ("blue".equals(type)) {
            socks = new WomenSocks("blue", 23, "sport");
        } else if ("red".equals(type)) {
            socks = new MenSocks("red", 31, 5);
        } else if ("yellow".equals(type)) {
            socks = new ChildrenSocks("yellow", 20, true);
        } else socks = new MenSocks("black", 33, 6);

        return socks;
    }

    public Socks createSocksBySize(int type) {
        SocksClass socks = null;

        if (type == 20) {
            socks = new ArmySocks("red", 31, 5);
        } else if (type == 22) {
            socks = new ArmySocks("red", 31, 5);
        } else if (type == 23) {
            socks = new JustinTrudoSocks("yellow", 20, 7);
        } else socks = new JustinTrudoSocks("yellow", 20, 7);

        return socks;
    }

    public static void main(String[] args) {
        KyivFactory factory = new KyivFactory();
        Socks s = factory.getSocks("red");
        System.out.println(s.toString());

        AbstractSocksFactory factory1 = FactoryProducer.getFactory("Kyiv");
        Socks socks = factory1.getSocks("blue");
        System.out.println(s.toString());
    }
}
