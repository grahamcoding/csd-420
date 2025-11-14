/**
 * Daniel Graham
 * Module 5 LinkedList
 * 11/14/2025
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Collections;

public class WordSetTest {

    public static void main(String[] args) {

        // This HashSet will store all the words without duplicates
        Set<String> words = new HashSet<>();

        // Read the words from the file
        readWords("collection_of_words.txt", words);

        // Sort the words in ascending order using TreeSet
        TreeSet<String> ascending = new TreeSet<>(words);

        // Sort the words in descending order
        TreeSet<String> descending = new TreeSet<>(Collections.reverseOrder());
        descending.addAll(words);

        // Print words in ascending order
        System.out.println("Words in Ascending Order:");
        for (String w : ascending) {
            System.out.println(w);
        }

        // Print words in descending order
        System.out.println("\nWords in Descending Order:");
        for (String w : descending) {
            System.out.println(w);
        }

        runTests(words);
    }

    public static void readWords(String fileName, Set<String> set) {
        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String word = input.next();

                // Convert to lowercase and remove punctuation
                word = word.toLowerCase();
                word = word.replaceAll("[^a-z]", "");

                if (!word.isEmpty()) {
                    set.add(word);
                }
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file: " + fileName);
        }
    }

    // Test code to make sure things work
    public static void runTests(Set<String> set) {
        System.out.println("\n--- Running Simple Tests ---");

        // Test 1: Make sure the set has words
        System.out.println("Test 1: Set not empty = " + (!set.isEmpty()));

        // Test 2: Check if duplicates were removed
        Set<String> duplicateCheck = new HashSet<>(set);
        System.out.println("Test 2: No duplicates = " + (duplicateCheck.size() == set.size()));

        // Test 3: Optional example - see if a common word is in the set
        System.out.println("Test 3: Contains 'the' = " + set.contains("the"));
    }
}
