import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // loggers Hierarchy
        Logger loggerA = Logger.getLogger("A");
        Logger loggerB = Logger.getLogger("A.B");
        Logger loggerC = Logger.getLogger("A.B.C");
        // set loggers level
        loggerA.setLevel(Level.FINE);
        loggerC.setLevel(Level.FINEST);
        // FileHandle (log files)
        Handler handlerA = new FileHandler("A.log");
        Handler handlerB = new FileHandler("B.log");
        Handler handlerC = new FileHandler("C.log");
        // logger relation with handler
        loggerA.addHandler(handlerA);
        loggerB.addHandler(handlerB);
        loggerC.addHandler(handlerC);

        loggerA.log(Level.FINEST, "A finest message on A");
        loggerB.log(Level.FINEST, "A finest message on B");
        loggerC.log(Level.FINEST, "A finest message on C");

        System.out.println(loggerA.getParent().getLevel());
        System.out.println(loggerA.getLevel());
        System.out.println(loggerB.getLevel());
        System.out.println(loggerC.getLevel());
        System.out.println();
    }
}