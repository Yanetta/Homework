package patterns.adapter;

public class AdapterClass implements Duck  {
    private Turkey turkey;
    public void DuckMethod() {
        turkey.method();
    }
}
