import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path basePath = Path.of(".").toAbsolutePath();
        Path codeClass = Path.of("src", "Main.java");//   (codeClass) --> src\Main.java

        Path codeClassPath = basePath.resolve(codeClass);// because the parameter path is not absolute return (invokingPath + path2) else return the absolute path
        Path imagesPath = codeClassPath.resolveSibling("images").normalize();
        // the normalize() method delete temp information like dot for example(etc\.\etc)
        //if invokingPath = “C:\Work” then return “C:\” + path2 namely (src\Work) then return (src\image) go to parent file (..) and cd to images directory or file

        System.out.println("Base: " + basePath);
        System.out.println("Code: " + codeClassPath);
        System.out.println("images: " + imagesPath);
        // return the related path from invoking (codeClassPath) path to parameter path (imagesPath)
        Path relCodeToImages = codeClassPath.relativize(imagesPath);
        System.out.println("Relative path: " + relCodeToImages);

    }
}