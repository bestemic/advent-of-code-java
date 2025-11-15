package com.bestemic.aoc.year2015;

import com.bestemic.aoc.Solution;
import com.bestemic.aoc.utils.InputReader;
import com.bestemic.aoc.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;

import static com.bestemic.aoc.utils.Constants.DAY_04;
import static com.bestemic.aoc.utils.Constants.YEAR_2015;

public class Day04 implements Solution {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day04.class);

    /**
     * Expected output: 117946
     */
    @Override
    public String part1(List<String> input) {
        String key = input.getFirst();
        return String.valueOf(mine(key, "00000"));
    }

    /**
     * Expected output: 3938038
     */
    @Override
    public String part2(List<String> input) {
        String key = input.getFirst();
        return String.valueOf(mine(key, "000000"));
    }

    private int mine(String key, String pattern) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            for (int i = 1; ; i++) {
                byte[] hash = md.digest((key + i).getBytes());
                String hex = HexFormat.of().formatHex(hash);

                if (hex.startsWith(pattern)) {
                    return i;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            List<String> input = InputReader.readLines(YEAR_2015, DAY_04);

            Solution solution = new Day04();
            String solutionPart1 = solution.part1(input);
            String solutionPart2 = solution.part2(input);

            Utils.logResults(DAY_04, solutionPart1, solutionPart2);
        } catch (IOException e) {
            LOGGER.error("Error while reading data: {}", e.getMessage(), e);
        }
    }
}
