public class Main {

    public static void main(String[] args) {

        String pattern="[0-2][0-3]:[0-5]\\d";
        System.out.println("01:49".matches(pattern));// true
        System.out.println("11:01".matches(pattern));// true
        System.out.println("25:11".matches(pattern));// false

        String pattern2="[0-2][0-3]:[0-5]\\d:[0-5]\\d(.\\d{1,4})?";
        System.out.println("01:49:39".matches(pattern2));// true
        System.out.println("11:01:38.11".matches(pattern2));// true
        System.out.println("22:11:88.11213".matches(pattern2));// false because 5 digits for nano seconds
    }
}

