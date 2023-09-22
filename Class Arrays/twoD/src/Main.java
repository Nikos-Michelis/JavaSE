import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] intAr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(intAr);
        System.out.println(intAr.toString());
        System.out.println(Arrays.toString(intAr));
        System.out.println(Arrays.toString(intAr[2]));
        System.out.println(Arrays.deepToString(intAr));
    }
}
