package patterns.proxy;

public class ProxyPrinterUse {
    public static void main(String[] args) {
        PrintInterface printer = new ProxyPrinter("To be, or not to be: that is the question", 4);
        printer.print();

    }
}
