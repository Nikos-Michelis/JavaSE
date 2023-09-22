import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Classic Hashset can modified from programmer
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set,1,8);
        // create a set with defences (unmodifiableSet) and with this another programmer can't modify the Hashset like(delete, add, replace...)
        Set<Integer> unmodSet = Collections.unmodifiableSet(set);
        System.out.println(unmodSet);
        set.add(3);
        System.out.println(unmodSet);
        unmodSet.add(5); // throws: UnsupportedOperationException

    }
}
