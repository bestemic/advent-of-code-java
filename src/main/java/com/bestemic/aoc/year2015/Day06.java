package com.bestemic.aoc.year2015;

import com.bestemic.aoc.Solution;
import com.bestemic.aoc.utils.InputReader;
import com.bestemic.aoc.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static com.bestemic.aoc.utils.Constants.DAY_06;
import static com.bestemic.aoc.utils.Constants.YEAR_2015;

public class Day06 implements Solution {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day06.class);

    public static void main(String[] args) {
        try {
            List<String> input = InputReader.readLines(YEAR_2015, DAY_06);

            Solution solution = new Day06();
            String solutionPart1 = solution.part1(input);
            String solutionPart2 = solution.part2(input);

            Utils.logResults(DAY_06, solutionPart1, solutionPart2);
        } catch (IOException e) {
            LOGGER.error("Error while reading data: {}", e.getMessage(), e);
        }
    }

    /**
     * Expected output: 569999
     */
    @Override
    public String part1(List<String> input) {
        boolean[][] grid = new boolean[1000][1000];

        input.forEach(line -> {
            Instruction instruction = parseInstruction(line);

            for (int x = instruction.startX; x <= instruction.endX; x++) {
                for (int y = instruction.startY; y <= instruction.endY; y++) {
                    switch (instruction.type) {
                        case ON -> grid[x][y] = true;
                        case OFF -> grid[x][y] = false;
                        case TOGGLE -> grid[x][y] = !grid[x][y];
                    }
                }
            }
        });

        int count = 0;
        for (boolean[] row : grid) {
            for (boolean light : row) {
                if (light) count++;
            }
        }
        return String.valueOf(count);
    }

    /**
     * Expected output: 17836115
     */
    @Override
    public String part2(List<String> input) {
        int[][] grid = new int[1000][1000];

        input.forEach(line -> {
            Instruction instruction = parseInstruction(line);

            for (int x = instruction.startX; x <= instruction.endX; x++) {
                for (int y = instruction.startY; y <= instruction.endY; y++) {
                    switch (instruction.type) {
                        case ON -> grid[x][y] += 1;
                        case OFF -> grid[x][y] = Math.max(0, grid[x][y] - 1);
                        case TOGGLE -> grid[x][y] += 2;
                    }
                }
            }
        });

        int brightness = 0;
        for (int[] row : grid) {
            for (int value : row) {
                brightness += value;
            }
        }
        return String.valueOf(brightness);
    }

    private Instruction parseInstruction(String line) {
        String[] parts = line.split(" ");

        InstructionType type;
        String start, end;

        if (parts[0].equals("turn")) {
            type = parts[1].equals("on") ? InstructionType.ON : InstructionType.OFF;
            start = parts[2];
            end = parts[4];
        } else {
            type = InstructionType.TOGGLE;
            start = parts[1];
            end = parts[3];
        }

        String[] startCords = start.split(",");
        String[] endCords = end.split(",");

        return new Instruction(
                type,
                Integer.parseInt(startCords[0]),
                Integer.parseInt(startCords[1]),
                Integer.parseInt(endCords[0]),
                Integer.parseInt(endCords[1])
        );
    }

    private enum InstructionType {ON, OFF, TOGGLE}

    private record Instruction(InstructionType type, int startX, int startY, int endX, int endY) {
    }
}
