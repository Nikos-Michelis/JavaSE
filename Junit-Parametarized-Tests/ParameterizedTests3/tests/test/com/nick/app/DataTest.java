package com.nick.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
// Data generator method
public class DataTest {
    // create a stream with arguments
    private static Stream<Arguments> testRecords3() {
        return Stream.of(
                Arguments.of("Tom", 1),
                Arguments.of("Bob", 2)
        );
    }
}