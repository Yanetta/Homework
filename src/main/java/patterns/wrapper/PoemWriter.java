package patterns.wrapper;

public class PoemWriter implements Writer {
    private String poem;

    public PoemWriter(String poem) {
        this.poem = poem;
    }

    @Override
    public void write() {
        System.out.println(poem);

    }
}
