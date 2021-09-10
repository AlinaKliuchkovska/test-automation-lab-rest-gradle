package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomGenerators {

    public static Long randomIdGenerator() {
        return Math.abs(new Random().nextLong());
    }

    public static String randomStringGenerator() {
        return RandomStringUtils.randomAlphabetic(5);
    }
}
