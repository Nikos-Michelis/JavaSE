import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void dirCopy(Path source, Path target) throws IOException {
        Files.walkFileTree(source,//access to directories and files for temp dir
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                            throws IOException
                    {
                        Path targetdir = target.resolve(source.relativize(dir));
                        System.out.println(targetdir);
                        try {
                            Files.copy(dir, targetdir);
                        } catch (FileAlreadyExistsException e) {
                            if (!Files.isDirectory(targetdir))
                                throw e;
                        }
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                            throws IOException
                    {
                        System.out.println("Source dyr for copy = " + source);
                        System.out.println("Target dyr: = " + target);
                        System.out.println("current source file = " + file);

                        System.out.println("1. take the path file = " + target.resolve(file));
                        System.out.println("2. take the related path for file that we want to copy = " + source.relativize(file));
                        System.out.println("3. Concatenate the: " + "C:\\temp2" + " + " + source.relativize(file) + " = " + target.resolve(source.relativize(file)));
                        System.out.println( Files.copy(file, target.resolve(source.relativize(file))));
                        return FileVisitResult.CONTINUE;
                    }
                });
    }

    public static void dirDelete(Path dir) throws IOException {
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException
            {
                if (e == null) {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed
                    throw e;
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {

        dirCopy(Path.of("C:\\temp"),Path.of("C:\\temp2"));
        dirDelete(Path.of("C:\\temp2"));
    }
}