package com.nick.app;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;
// 1.  TestData method must implement the interface ArgumentsProvider
// 2.  The method provideArguments() must Redefine
public class TestData2 implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("Pam", 3),
                Arguments.of("John", 4)
        );
    }
}