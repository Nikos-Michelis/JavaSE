import java.util.Iterator;
import java.util.TreeMap;

public class MyTreeMap<K,V> extends TreeMap<K,V> implements Iterable<K> {
    TreeMap<K,V> tree;

    public MyTreeMap() {
        tree = new TreeMap<>();
    }

    class ClassIterator implements Iterator<K> {
        K prev = null;
        @Override
        public boolean hasNext() {
            return prev!=lastKey();
        }

        @Override
        public K next() {
            if (prev==null)
                prev=firstKey();
            else
                prev=higherKey(prev);
            return prev;
        }
    }
    @Override
    public Iterator<K> iterator() {
        return new ClassIterator();
    }
}