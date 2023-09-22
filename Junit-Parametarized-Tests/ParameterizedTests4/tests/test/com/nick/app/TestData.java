package com.nick.app;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;
// 1. TestData method must implement the interface ArgumentsProvider
public class TestData implements ArgumentsProvider {
    // 2. Redefinition of method provideArguments()
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("Tom", 1),
                Arguments.of("Bob", 2)
        );
    }
}