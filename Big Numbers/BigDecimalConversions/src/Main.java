import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("256");

        try {
            byte by = b.byteValueExact();
        } catch (ArithmeticException e) {
            System.out.println("Byte Overflow");//return arithmetic Exception because 256 doesn't fit to 1 bit must be > 255 bytes
        }

        BigDecimal b2 = new BigDecimal("0.12345678901");
        Float f = b2.floatValue();
        System.out.println(f);

        System.out.println(b2.movePointLeft(3));// move subdivision 3 positions left
        System.out.println(b2.movePointRight(3));// move subdivision 3 positions right
    }
}
