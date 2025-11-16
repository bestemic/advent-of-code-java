package com.bestemic.aoc.year2015;

import com.bestemic.aoc.Solution;
import com.bestemic.aoc.utils.InputReader;
import com.bestemic.aoc.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.bestemic.aoc.utils.Constants.DAY_02;
import static com.bestemic.aoc.utils.Constants.YEAR_2015;

public class Day02 implements Solution {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day02.class);

    public static void main(String[] args) {
        try {
            List<String> input = InputReader.readLines(YEAR_2015, DAY_02);

            Solution solution = new Day02();
            String solutionPart1 = solution.part1(input);
            String solutionPart2 = solution.part2(input);

            Utils.logResults(DAY_02, solutionPart1, solutionPart2);
        } catch (IOException e) {
            LOGGER.error("Error while reading data: {}", e.getMessage(), e);
        }
    }

    /**
     * Expected output: 1588178
     */
    @Override
    public String part1(List<String> input) {
        int result = input.stream()
                .mapToInt(this::wrappingPaperForBox)
                .sum();

        return String.valueOf(result);
    }

    /**
     * Expected output: 3783758
     */
    @Override
    public String part2(List<String> input) {
        int result = input.stream()
                .mapToInt(this::ribbonForBox)
                .sum();

        return String.valueOf(result);
    }

    private int wrappingPaperForBox(String line) {
        int[] dimensions = parseDimensions(line);
        int l = dimensions[0], w = dimensions[1], h = dimensions[2];

        int side1 = l * w;
        int side2 = w * h;
        int side3 = h * l;

        int surfaceArea = 2 * (side1 + side2 + side3);
        int slack = Math.min(side1, Math.min(side2, side3));

        return surfaceArea + slack;
    }

    private int ribbonForBox(String line) {
        int[] dimensions = parseDimensions(line);
        int l = dimensions[0], w = dimensions[1], h = dimensions[2];

        int volume = l * w * h;

        int perimeter1 = 2 * (l + w);
        int perimeter2 = 2 * (w + h);
        int perimeter3 = 2 * (h + l);

        int smallestPerimeter = Math.min(perimeter1, Math.min(perimeter2, perimeter3));

        return volume + smallestPerimeter;
    }

    private int[] parseDimensions(String line) {
        return Arrays.stream(line.split("x"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
