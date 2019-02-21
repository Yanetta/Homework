package patterns.wrapper;

public class WrappedPoemWriterUse {
    public static void main(String[] args) {
        String poem = "Tyger Tyger, burning bright,\n" +
                "In the forests of the night;\n" +
                "What immortal hand or eye,\n" +
                "Could frame thy fearful symmetry?";
        Writer wrappedPoemWriter = new WrappedPoemWriter(new PoemWriter(poem));
        wrappedPoemWriter.write();

    }
}
