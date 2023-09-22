import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i=0; i<50; i++)
            al.add(i);

        System.out.println(al);
        // Lambda Method A
        al.forEach(System.out::println);
        // Lambda Method B
        al.forEach((n)->System.out.println(n));
    }
}