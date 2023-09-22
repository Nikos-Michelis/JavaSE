import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(List.of(1,2,3,4,5));
        ArrayList<Integer> array2 = new ArrayList<>(List.of(6,7,8,9,10));
        // copy array2 to array
        Collections.copy(array, array2);
        System.out.println(array);
        // return the first appearance of the element from left top right
        System.out.println(Collections.indexOfSubList(
                array,//list source
                List.of(7,8)//list target
        ));
        // return the last appearance of the element from right to left
        System.out.println(Collections.lastIndexOfSubList(
                //index 0 1 2 3 4 5 6 7
                List.of(1,2,1,2,1,2,1,2),//list source
                List.of(2,1,2)//list target
        ));
    }
}
