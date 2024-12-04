package com.bestemic.aoc.year2024;

import com.bestemic.aoc.Solution;
import com.bestemic.aoc.utils.InputReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.bestemic.aoc.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {

    private static Solution solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Day04();
    }

    @Test
    void testPart1() throws IOException {
        List<String> input = InputReader.readTestLines(YEAR_2024, DAY_04 + PART_1);
        String result = solution.part1(input);

        assertEquals("18", result);
    }

    @Test
    void testPart2() throws IOException {
        List<String> input = InputReader.readTestLines(YEAR_2024, DAY_04 + PART_2);
        String result = solution.part2(input);

        assertEquals("9", result);
    }
}