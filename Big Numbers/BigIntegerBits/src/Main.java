import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("1");
        BigInteger b2 = b.setBit(1).setBit(2);
        System.out.println(b2);
        System.out.println(b.xor(b2));
        System.out.println(b2.shiftRight(1));
        int x = new BigInteger("1234567890123").intValueExact();
    }
}