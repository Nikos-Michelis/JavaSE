import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set,1,8,2,3,5,6,4,7);
        System.out.println("Min element: " + Collections.min(set));
        ArrayDeque<Person> deque = new ArrayDeque<>();
        Collections.addAll(deque,
                new Person("William", "Kunstler", "Trafalgar sq"),
                new Person("Abbie", "Hoffman", "11th str"));
        System.out.println("Max element: " + Collections.max(deque,
                Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName)));
    }
}