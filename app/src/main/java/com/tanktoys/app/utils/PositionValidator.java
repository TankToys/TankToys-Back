package com.tanktoys.app.utils;

public class PositionValidator {
    public static boolean validate(int[][] positions) {
        if (positions.length == 24 && positions[0].length == 16) {
            return true;
        }
        return false;
    }
}
