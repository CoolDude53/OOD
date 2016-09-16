package HW2.utils;

import HW2.players.logic.Difficulty;
import HW2.players.logic.Easy;
import HW2.players.logic.Hard;
import HW2.players.logic.Medium;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils
{
    private static Random rand = new Random();
    private static Easy easy = new Easy();
    private static Medium medium = new Medium();
    private static Hard hard = new Hard();

    public static int randInt(int min, int max)
    {
        return rand.nextInt(Math.abs(max - min) + 1) + min;
    }

    public static Difficulty difficultyFromString(String string)
    {
        switch (string.toLowerCase())
        {
            case "easy":
                return easy;
            case "medium":
                return medium;
            case "hard":
                return hard;
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
