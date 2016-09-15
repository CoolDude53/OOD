package HW2.utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils
{
    private static Random rand = new Random();

    public static int randInt(int min, int max)
    {
        return rand.nextInt(Math.abs(max - min) + 1) + min;
    }

    public static Difficulty difficultyFromString(String string)
    {
        switch (string.toLowerCase())
        {
            case "easy":
                return Difficulty.EASY;
            case "medium":
                return Difficulty.MEDIUM;
            case "hard":
                return Difficulty.HARD;
            case "mixed":
                return Difficulty.MIXED;
            default:
                return null;
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map)
    {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
