import java.util.LinkedHashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> map = new LinkedHashMap<>();
        LinkedHashMap<Integer,String> map2 = new LinkedHashMap<>(16,0.75f, true);
        Random r = new Random();
        for (int i=0; i<20; i++) {
            int v = r.nextInt(10);//create a random keys in range 0 - 10
            System.out.println(v);//print random values for keys
            map.put(v, "val");//put an random value to the key value
            map2.put(v, "val");
        }
        System.out.println(map);
        for (int i=0; i<2; i++) {//
            int v = r.nextInt(10);
            map2.get(v);//access to index and retrieve the data for current key
            System.out.println("key: "+ v + "--" + map2);//list recently used (else elem history)
        }
    }
}