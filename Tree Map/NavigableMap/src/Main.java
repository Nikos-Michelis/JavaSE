import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        Random r = new Random();
        for (int i= 0; i<10; i++)
            map.put(r.nextInt(100), "val");

        System.out.println(map);
        System.out.println(map.floorKey(50));//return the elem that is >= (from parameter)
        System.out.println(map.ceilingEntry(50));//return the elem that is > (from parameter)
        System.out.println(map.descendingMap());//return a map with descending order
        System.out.println(map.descendingKeySet());//return a map with descending order

        for (var v: map.descendingMap().entrySet())
            System.out.println("Key: " + v.getKey() + ", value: " + v.getValue());
    }
}