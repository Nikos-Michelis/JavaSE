import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> array = new LinkedList<>(List.of(1,2,3,4,5));
        ArrayList<Integer> array2 = new ArrayList<>(List.of(6,7,8,9,10));
        // return true or false if the collections we have same items
        System.out.println("No common elements: " + Collections.disjoint(array, array2));
        // add elements to array collection
        Collections.addAll(array, 1, 8, 2, 4, 5);
        System.out.println("No common elements: " + Collections.disjoint(array, array2));
        System.out.println("1 appears " + Collections.frequency(array, 1) + " times");
    }
}