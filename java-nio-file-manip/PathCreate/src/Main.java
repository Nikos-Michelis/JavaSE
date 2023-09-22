import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        System.out.println( // absolute path, folder
                Path.of("C:","Work","Java")); // absolute
        System.out.println( // absolute path, file doesn't exists
                Path.of("C:\\Work\\Java", "empty.txt")); // wrap a absolute path and doesn't make the file
        System.out.println( //relative
                Path.of(".."));// parent catalog
        System.out.println( //relative
                Path.of(".", "src", "Main.java"));

    }
}