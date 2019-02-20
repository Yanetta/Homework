package patterns.socks;

public class ChildrenSocks extends SocksClass {

    boolean certif;

    public ChildrenSocks(String color, int size, boolean certif) {
        super(color, size);
        this.certif = certif;
    }

    public boolean isCertif() {
        return certif;
    }

    public void setCertif(boolean certif) {
        this.certif = certif;
    }

    @Override
    public String toString() {
        return "ChildrenSocks{" +
                "certif=" + certif +
                '}';
    }
}

