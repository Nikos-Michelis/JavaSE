import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path rel = Path.of("src", "Main.java");
        Path abs = rel;
        if (!rel.isAbsolute())
            abs = rel.toAbsolutePath();
        System.out.println("Relative: " + rel);
        System.out.println("Absolute: " + abs);
        System.out.println("Root: " + abs.getRoot());
        System.out.println("Filename: " + abs.getFileName());
        System.out.println("Iterate: ");
        for (Path ab : abs)
            System.out.print(ab + " ");
        // return the path between 0 -> (3-1) = 0 -> 2
        System.out.println("\nSubpath: " + abs.subpath(0, 3));

    }
}