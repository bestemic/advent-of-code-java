package com.bestemic.aoc.year2015;

import com.bestemic.aoc.Solution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {

    private static Solution solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Day04();
    }

    @ParameterizedTest(name = "input: {0} => expected: {1}")
    @CsvSource({
            "abcdef , 609043",
            "pqrstuv , 1048970"
    })
    void testPart1(String input, String expected) {
        String result = solution.part1(List.of(input));

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "input: {0} => expected: {1}")
    @CsvSource({
            "abcdef , 6742839",
            "pqrstuv , 5714438"
    })
    void testPart2(String input, String expected) {
        String result = solution.part2(List.of(input));

        assertEquals(expected, result);
    }
}
