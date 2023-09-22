import java.util.*;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("OS", "Windows");
        properties.setProperty("Screen", "LG $%@$#");
        properties.setProperty("Analysis", "640x480");

        for (Object o : properties.keySet()) {
            String key = (String) o;
            System.out.println(key + ": " + properties.getProperty(key));
        }
    }
}
