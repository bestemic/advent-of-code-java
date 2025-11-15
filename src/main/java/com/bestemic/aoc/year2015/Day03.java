package com.bestemic.aoc.year2015;

import com.bestemic.aoc.Solution;
import com.bestemic.aoc.utils.InputReader;
import com.bestemic.aoc.utils.Point;
import com.bestemic.aoc.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bestemic.aoc.utils.Constants.DAY_03;
import static com.bestemic.aoc.utils.Constants.YEAR_2015;

public class Day03 implements Solution {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day03.class);

    /**
     * Expected output: 2565
     */
    public String part1(List<String> input) {
        String directions = input.getFirst();
        Set<Point> visited = new HashSet<>();

        Point santa = new Point(0, 0);
        visited.add(santa);

        for (char direction : directions.toCharArray()) {
            santa = move(direction, santa);
            visited.add(santa);
        }

        return String.valueOf(visited.size());
    }

    /**
     * Expected output: 2639
     */
    @Override

    public String part2(List<String> input) {
        char[] directions = input.getFirst().toCharArray();
        Set<Point> visited = new HashSet<>();

        Point santa = new Point(0, 0);
        Point robot = new Point(0, 0);
        visited.add(santa);
        visited.add(robot);

        for (int i = 0; i < directions.length; i += 2) {
            santa = move(directions[i], santa);
            visited.add(santa);

            robot = move(directions[i + 1], robot);
            visited.add(robot);
        }

        return String.valueOf(visited.size());
    }

    private Point move(char direction, Point position) {
        return switch (direction) {
            case '^' -> new Point(position.x(), position.y() + 1);
            case 'v' -> new Point(position.x(), position.y() - 1);
            case '>' -> new Point(position.x() + 1, position.y());
            case '<' -> new Point(position.x() - 1, position.y());
            default -> position;
        };
    }

    public static void main(String[] args) {
        try {
            List<String> input = InputReader.readLines(YEAR_2015, DAY_03);

            Solution solution = new Day03();
            String solutionPart1 = solution.part1(input);
            String solutionPart2 = solution.part2(input);

            Utils.logResults(DAY_03, solutionPart1, solutionPart2);
        } catch (IOException e) {
            LOGGER.error("Error while reading data: {}", e.getMessage(), e);
        }
    }
}
