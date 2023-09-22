import java.util.Iterator;

public class Animals implements Iterable<String> {
    int n;
    String[] animals;
    class ClassIterator implements
            Iterator<String> {
        int i=-1;
        @Override
        public boolean hasNext() {
            return i<n-1;
        }
        @Override
        public String next() {
            i++;
            return animals[i];
        }
    }
    @Override
    public Iterator<String>
    iterator() {
        return new ClassIterator();
    }
}
