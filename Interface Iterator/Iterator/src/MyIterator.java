import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {
    int i=-1;
    int n=10;
    @Override
    public boolean hasNext() {
        return i<n;
    }
    // return the next integer
    @Override
    public Integer next() {
        return ++i;
    }
}