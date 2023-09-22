package com.nick.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    private static Stream<Arguments> provider1() {
        return Stream.of(
                Arguments.of("Tom", 1),
                Arguments.of("Bob", 2)
        );
    }
    // get parameters from method provider1
    @ParameterizedTest
    @MethodSource("provider1")
    void testRecords(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }
    // create a list with arguments
    private static List<Arguments> provider2() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.of("Pam", 3));
        return list;
    }
    // get parameters from method provider2
    @ParameterizedTest
    @MethodSource("provider2")
    void testRecords2(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }

    // create a stream with arguments
    private static Stream<Arguments> testRecords3() {
        return Stream.of(
                Arguments.of("Tom", 1),
                Arguments.of("Bob", 2)
        );
    }
    // take the parameters from method with that test have the same name
    @ParameterizedTest
    @MethodSource
    void testRecords3(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }
    // take a parameters for test from method in another class namely in clas DataTest
    @ParameterizedTest
    @MethodSource("com.nick.app.DataTest#testRecords3")
    void testRecords4(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }
}