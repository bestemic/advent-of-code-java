package com.bestemic.aoc.year2015;

import com.bestemic.aoc.Solution;
import com.bestemic.aoc.utils.InputReader;
import com.bestemic.aoc.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static com.bestemic.aoc.utils.Constants.DAY_01;
import static com.bestemic.aoc.utils.Constants.YEAR_2015;

public class Day01 implements Solution {
    private static final Logger LOGGER = LoggerFactory.getLogger(Day01.class);

    /**
     * Expected output: 280
     */
    @Override
    public String part1(List<String> input) {
        int floor = 0;

        for (char instruction : input.getFirst().toCharArray()) {
            floor += (instruction == '(') ? 1 : -1;
        }
        return String.valueOf(floor);
    }

    /**
     * Expected output: 1797
     */
    @Override
    public String part2(List<String> input) {
        int floor = 0;
        int instructionNumber = 0;
        char[] instructions = input.getFirst().toCharArray();

        for (char instruction : instructions) {
            instructionNumber++;
            floor += (instruction == '(') ? 1 : -1;

            if (floor < 0) {
                break;
            }
        }
        return String.valueOf(instructionNumber);
    }

    public static void main(String[] args) {
        try {
            List<String> input = InputReader.readLines(YEAR_2015, DAY_01);

            Solution solution = new Day01();
            String solutionPart1 = solution.part1(input);
            String solutionPart2 = solution.part2(input);

            Utils.logResults(DAY_01, solutionPart1, solutionPart2);
        } catch (IOException e) {
            LOGGER.error("Error while reading data: {}", e.getMessage(), e);
        }
    }
}
