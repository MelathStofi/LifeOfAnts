package com.codecool.util;

import java.util.Random;

public class RandomGenerator {

    public static int generateRandIntInRange(int bound) {
        return new Random().nextInt(bound);
    }

    public static int generateRandIntInRange(int start, int end) {
        return new Random().nextInt((end - start) + 1) + start;
    }

    public static boolean chanceEvaluator(double chance) {
        double randNum = new Random().nextDouble();
        randNum = randNum * 100;
        return randNum < chance;
    }
}
