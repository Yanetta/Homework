package patterns.proxy;

public class ProxyPrinter implements PrintInterface {
String textForPrinting;
    PrintInterface printer;
    int condition;

    public ProxyPrinter(String textForPrinting, int condition) {

        this.condition = condition;
        this.textForPrinting = textForPrinting;
    }

    @Override
    public void print() {
        if (printer == null){
            printer = new Printer(textForPrinting);
        }
        if (condition > 3){
        printer.print();
    }
    else {
            System.out.println("Access denied!");}
    }
}
