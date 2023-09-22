import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        Path basePath = Path.of("C:\\temp");
        Path newDir = basePath.resolve("exDir");
        Files.createDirectory(newDir);
        Files.createDirectories(basePath.resolve("1\\2\\3"));
        Path newFile = Files.createFile(newDir.resolve("temp.txt"));

        try {
            Files.createDirectory(newDir);
        }
        catch(FileAlreadyExistsException e) {
            System.out.println("Directory already exists");
        }

        Path tempFile = Files.createTempFile(null, null);
        System.out.println(tempFile);

        Path linkFile = Files.createSymbolicLink(
                newDir.resolve("link.txt"),
                newFile
        );
    }
}