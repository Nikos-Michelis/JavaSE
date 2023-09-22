import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {


    public static void main(String[] args){

        try {
            Path basePath = Path.of("C:\\temp");
            try {
                Files.delete(basePath);
            }
            catch (DirectoryNotEmptyException e) {
                System.out.println(basePath + " is not empty!");
            }

            try {
                Path dirToDelete = basePath.resolve("1\\2\\3");
                Files.delete(dirToDelete);
                System.out.println(dirToDelete + " deleted!");
            }
            catch (DirectoryNotEmptyException e) {
                e.printStackTrace();
            }
            Path aFile = basePath.resolve("exDir\\temp.txt");// source
            Path newFile = basePath.resolve("exDir\\temp2.txt");// new file

            Files.copy(aFile, newFile);
            Files.move(newFile, basePath.resolve("temp.txt"));// move newFile (temp2.txt) to basePath\temp.txt
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}