package com.nick.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    // get data from CsvSource
public class DataTest {
    @ParameterizedTest
    @CsvSource({"1", "1,2", "1,2,3"})
    void testRecords(ArgumentsAccessor argumentsAccessor) {
        if (argumentsAccessor.size()==2)
            assertTrue(true);
        else
            fail();
    }
    // get arguments data from class ConvertArguments, that class return a list with arguments and the class testRecords2 manage that arguments as typical list
    // namely a list have multiple data
    @ParameterizedTest
    @CsvSource({"1", "1,2", "1,2,3"})
    void testRecords2(@AggregateWith(ConvertArguments.class) List<String> argList) {
        if (argList.contains("2"))
            assertTrue(true);
        else
            fail();
    }
}