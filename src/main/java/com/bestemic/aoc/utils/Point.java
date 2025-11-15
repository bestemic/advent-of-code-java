package com.bestemic.aoc.utils;

public record Point(int x, int y) {

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
