package patterns.socks;

public class KyivFactory extends AbstractSocksFactory {
    @Override
    public Socks getSocks(String type) {
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

//    public static Socks createSocksByType(String type) {
//        SocksClass socks = null;
//
//        if ("blue".equals(type)) {
//            socks = new WomenSocks("blue", 23, "sport");
//        } else if ("red".equals(type)) {
//            socks = new MenSocks("red", 31, 5);
//        } else if ("yellow".equals(type)) {
//            socks = new ChildrenSocks("yellow", 20, true);
//        } else socks = new MenSocks("black", 33, 6);
//
//        return socks;
//    }
}
