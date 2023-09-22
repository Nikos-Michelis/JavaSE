import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String text = "Computer Science is no more about computers " +
                "than astronomy is about telescope";

        Matcher m = Pattern.compile("Sci.*? |comp.*? ").matcher(text);
        while(m.find())
            System.out.println(m.group());
    }
}

