package patterns.socks;

public class ChineezeFactory extends AbstractSocksFactory {
    @Override
    public Socks getSocks(String type) {

            SocksClass socks = null;

            if ("blue".equals(type)) {
                socks = new ArmySocks("red", 31, 5);
            } else if ("red".equals(type)) {
                new ArmySocks("red", 31, 5);
            } else if ("yellow".equals(type)) {
        socks = new JustinTrudoSocks("yellow", 20, 7);
            } else socks = new MenSocks("black", 33, 6);

            return socks;
        }
    }

//    public Socks createSocksBySize(int type)  {
//        SocksClass socks = null;
//
//        if (type == 20) {
//            socks = new ArmySocks("red", 31, 5);
//        } else if (type == 22) {
//            socks = new ArmySocks("red", 31, 5);
//        } else if (type == 23) {
//            socks = new JustinTrudoSocks("yellow", 20, 7);
//        } else socks = new JustinTrudoSocks("yellow", 20, 7);
//
//        return socks;
//    }


