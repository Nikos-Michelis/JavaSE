package com.nick.app;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class DataTest {
    @TestFactory
    List<DynamicTest> listOfTests() {
        return List.of(
                DynamicTest.dynamicTest("Test1", ()-> {
                    assertTrue(true);
                }),
                DynamicTest.dynamicTest("Test2", ()-> {
                    fail();
                })
        );
    }

    @TestFactory
    Stream<DynamicTest> streamOfTests() {
        return Stream.of(
                DynamicTest.dynamicTest("Test1", ()-> {
                    assertTrue(true);
                }),
                DynamicTest.dynamicTest("Test2", ()-> {
                    fail();
                })
        );
    }


    @TestFactory
    Iterator<DynamicTest> iteratorOfTests() {
        return List.of(
                DynamicTest.dynamicTest("Test1", ()-> {
                    assertTrue(true);
                }),
                DynamicTest.dynamicTest("Test2", ()-> {
                    fail();
                })
        ).iterator();
    }
}