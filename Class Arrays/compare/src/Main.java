import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4,5}, // row 0
                {1,2,6,7,9,11}, //row 1
                {1,2,3,4,5,6}, // row 2
                {1,2,3,7,1,1} // row 3
        };
        //compare method return -1 because the array[0] have less elements from arra[2] namely the lement arra[0]-> 0 < array[2] -> 6
        System.out.println(Arrays.compare(array[0], array[2]));
        //compare method return -1 because the three first elements is equal but the 4 element is mismatch namely arra[2]-> 4 < array[3] -> 7
        System.out.println(Arrays.compare(array[2], array[3]));
        //compare method return 1 because the array[3] > array[2] namely 7>4
        System.out.println(Arrays.compare(array[3], array[2]));
        Arrays.sort(array, Arrays::compare);
        System.out.println(Arrays.deepToString(array));
    }
}
