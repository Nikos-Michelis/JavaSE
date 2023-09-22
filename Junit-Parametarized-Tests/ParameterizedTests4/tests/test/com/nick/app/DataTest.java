package com.nick.app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;

import static org.junit.jupiter.api.Assertions.*;

public class DataTest {
    // generate attributes from class TestData
    @ParameterizedTest
    @ArgumentsSource(TestData.class)
    void testRecords(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }
    // generate attributes from multiple classes  @ArgumentsSources() --> (TestData, TestData2, etc)
    @ParameterizedTest
    @ArgumentsSources({
            @ArgumentsSource(TestData.class),
            @ArgumentsSource(TestData2.class)
    })
    void testRecords2(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }
}