package wordfrequency;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordsFrequency {

    private static final String REGEX = "[^a-zA-Z]|\b|[0-9]";
    private static final String EMPTY = "";
    private static final String SPACE = " ";
    private static final String PRINT_FORMAT = "%s %d";

    public static Map<String, Long> calculateWordsFrequency(String content) {
        return Arrays.stream(content.split(SPACE))
                .map(word -> word.replaceAll(REGEX, EMPTY).toLowerCase().trim())
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        }, LinkedHashMap::new
                ));
    }

    public static void print(Map<String, Long> wordFrequencyMap) {
        wordFrequencyMap.forEach((word, frequency) -> System.out.println(String.format(PRINT_FORMAT, word, frequency)));
    }

    public static void printCalculateWordsFrequency(String content) {
        WordsFrequency.print(WordsFrequency.calculateWordsFrequency(content));
    }

}
