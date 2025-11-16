package com.bestemic.aoc.year2015;

import com.bestemic.aoc.Solution;
import com.bestemic.aoc.utils.InputReader;
import com.bestemic.aoc.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static com.bestemic.aoc.utils.Constants.DAY_05;
import static com.bestemic.aoc.utils.Constants.YEAR_2015;

public class Day05 implements Solution {

    private static final Logger LOGGER = LoggerFactory.getLogger(Day05.class);
    private static final Pattern THREE_VOWELS = Pattern.compile("[aeiou].*[aeiou].*[aeiou]", Pattern.CASE_INSENSITIVE);
    private static final Pattern DOUBLE_LETTER = Pattern.compile("([a-z])\\1", Pattern.CASE_INSENSITIVE);
    private static final Pattern PAIR_TWICE = Pattern.compile("([a-z]{2}).*\\1", Pattern.CASE_INSENSITIVE);
    private static final Pattern REPEAT_WITH_GAP = Pattern.compile("([a-z]).\\1", Pattern.CASE_INSENSITIVE);

    private static final Set<String> FORBIDDEN = Set.of("ab", "cd", "pq", "xy");

    public static void main(String[] args) {
        try {
            List<String> input = InputReader.readLines(YEAR_2015, DAY_05);

            Solution solution = new Day05();
            String solutionPart1 = solution.part1(input);
            String solutionPart2 = solution.part2(input);

            Utils.logResults(DAY_05, solutionPart1, solutionPart2);
        } catch (IOException e) {
            LOGGER.error("Error while reading data: {}", e.getMessage(), e);
        }
    }

    /**
     * Expected output: 258
     */
    @Override
    public String part1(List<String> input) {
        int niceWords = 0;

        for (String word : input) {
            if (hasThreeVowels(word) && hasDoubleLetter(word) && !containsForbidden(word)) {
                niceWords++;
            }
        }

        return String.valueOf(niceWords);
    }

    /**
     * Expected output: 53
     */
    @Override
    public String part2(List<String> input) {
        int niceWords = 0;

        for (String word : input) {
            if (hasPairTwice(word) && hasRepeatWithGap(word)) {
                niceWords++;
            }
        }

        return String.valueOf(niceWords);
    }

    private boolean hasThreeVowels(String word) {
        return THREE_VOWELS.matcher(word).find();
    }

    private boolean hasDoubleLetter(String word) {
        return DOUBLE_LETTER.matcher(word).find();
    }

    private boolean containsForbidden(String word) {
        for (String f : FORBIDDEN) {
            if (word.contains(f)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPairTwice(String word) {
        return PAIR_TWICE.matcher(word).find();
    }

    private boolean hasRepeatWithGap(String word) {
        return REPEAT_WITH_GAP.matcher(word).find();
    }
}
