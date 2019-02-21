package patterns.wrapper;

public class WrappedPoemWriter implements Writer {
    Writer poemWriter;

    public WrappedPoemWriter(Writer poemWriter) {
        this.poemWriter = poemWriter;
    }

    @Override
    public void write() {
        System.out.println("Poem is a piece of writing in which the expression of feelings and ideas is given intensity by particular attention to diction (sometimes involving rhyme), rhythm, and imagery.");
        System.out.println("This is an example of the poem: ");
        poemWriter.write();
    }
}
