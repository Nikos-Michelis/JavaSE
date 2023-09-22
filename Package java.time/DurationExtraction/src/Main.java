import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime birthday = LocalDateTime.of(1980, 23, 5,12,0);
        LocalDateTime now = LocalDateTime.now();

        Duration d2 = Duration.between(birthday, now);
        System.out.println(d2);
        //convert duration to date and time
        System.out.println("Years: " + d2.toDays()/365);
        System.out.println("Months: " + d2.toDays()/30);
        System.out.println("Days: " + d2.toDays());
        System.out.println("Hours: " + d2.toHours());
        System.out.println("Minutes: " + d2.toMinutes());
        System.out.println("Seconds: " + d2.toSeconds());
    }
}
