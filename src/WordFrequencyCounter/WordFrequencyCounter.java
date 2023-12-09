package WordFrequencyCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String fileName) throws IOException {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        return wordFrequencyMap;
    }

    public static void printWordFrequency(Map<String, Integer> wordFrequencyMap) {
        wordFrequencyMap.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    public static void main(String[] args) {
        try {
            Map<String, Integer> wordFrequencyMap = countWordFrequency("C:\\Users\\Пользователь\\IdeaProjects\\homework2\\src\\WordFrequencyCounter\\words.txt");
            printWordFrequency(wordFrequencyMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

