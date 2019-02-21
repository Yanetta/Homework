package patterns.proxy;

public class Printer implements PrintInterface {
    String textForPrinting;

    public Printer(String textForPrinting) {
        this.textForPrinting = textForPrinting;
    }

    public void print(){
        System.out.println(textForPrinting);

    }
}
