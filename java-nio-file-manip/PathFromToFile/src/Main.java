import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        // absolute
        Path p = Path.of("C:","Work","Java");//file patch Java--> C:\Work\Java
        System.out.println(p);
        // path (C:\Work\Java) to file
        File f = new File(p.toUri());
        System.out.println(f);
        // print the absolute path for file (f)--> C:\Work\Java
        Path p2 = Path.of(f.toURI());
        System.out.println(p2);

        // relative
       p = Path.of("..");
        System.out.println(p);
        System.out.println(p.toUri());
        // parent catalog path to file
        f = new File(p.toUri());
        System.out.println(f);
        // print the path for filr (f)
        p2 = Path.of(f.toURI());
        System.out.println(p2);
    }
}