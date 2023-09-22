package com.nick.app;

import static org.junit.jupiter.api.Assertions.*;

import com.nick.app.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class MainTest {
    @Test
    @Timeout(2)
    void testFib() {
        Main.fib(30);
        assertTrue(true);
    }

    @Test
    @Timeout(value=2, unit=TimeUnit.SECONDS)
    void testFib2() {
        Main.fib(45);
        assertTrue(true);
    }

    @Test
    void testFib3() {
        assertTimeoutPreemptively(Duration.ofSeconds(2),
                ()->{
                    Main.fib(100);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(ints={1, 5, 10, 20, 25, 30, 35, 40, 45, 50})
    @Timeout(value=2, unit=TimeUnit.SECONDS)
    void testFib4(int n) {
        assertTimeoutPreemptively(Duration.ofSeconds(2),
                ()->{
                    Main.fib(n);
                }
        );
    }
}