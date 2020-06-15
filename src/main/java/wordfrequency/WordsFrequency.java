package wordfrequency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordsFrequency {

    public static void printCalculateWordsFrequency(String fileName) {
        print(calculateWordsFrequency(getFileContext(fileName)));
    }

    private static String getFileContext(String fileName) {
        return getBufferedReaderFromFile(fileName)
                .lines()
                .collect(
                        Collectors.joining(System.lineSeparator())
                );
    }

    private static BufferedReader getBufferedReaderFromFile(String fileName) {
        return new BufferedReader(new InputStreamReader(WordsFrequency.class.getResourceAsStream("/" + fileName)));
    }

    public static Map<String, Long> calculateWordsFrequency(String content) {
        return Arrays.stream(content.split(" "))
                .map(word -> word.replaceAll("[^a-zA-Z]|\b|[0-9]", "").toLowerCase().trim())
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

    private static void print(Map<String, Long> wordFrequencyMap) {
        System.out.print(mapToString(wordFrequencyMap));
    }

    public static String mapToString(Map<String, Long> wordFrequencyMap) {
        return wordFrequencyMap.entrySet()
                .stream()
                .map(e -> e.getKey() + " " + e.getValue())
                .collect(Collectors.joining("\n"));
    }

}
