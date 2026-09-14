//Count word occurrences from a βile using File Handling APIs
import java.io.*;
import java.util.*;

public class Program5 {
    public static void main(String[] args) {
        String fileName = "Sample.txt";

        try {
            File file = new File(fileName);
            HashMap<String, Integer> wordCount;
            try (Scanner sc = new Scanner(file)) {
                wordCount = new HashMap<>();
                while (sc.hasNext()) {
                    String word = sc.next().toLowerCase();
                    word = word.replaceAll("[^a-zA-Z0-9]", "");
                    
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            System.out.println("=== Word Occurrences in File ===");
            System.out.printf("%-15s %-10s%n", "Word", "Count");
            System.out.println("-----------------------------");

            List<String> keys = new ArrayList<>(wordCount.keySet());
            Collections.sort(keys);

            for (String key : keys) {
                System.out.printf("%-15s %-10d%n", key, wordCount.get(key));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}