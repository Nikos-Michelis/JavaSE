import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("a.b.");

        String str = "abba";
        System.out.println(str + ": " + pattern.matcher(str).matches());//matches(true)
        str = "baba";
        System.out.println(str + ": " + pattern.matcher(str).matches());//false
        str = "abbaa";
        System.out.println(str + ": " + pattern.matcher(str).matches());//false
        str = "acbz";
        System.out.println(str + ": " + pattern.matcher(str).matches());//true
        str = "aaabba";
        System.out.println(str + ": " + pattern.matcher(str).matches());//false
    }
}

