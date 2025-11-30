/**
 * Daniel Graham
 * CSD 420 Module 6 - Bubble Sort
 * 11/22/2025
 */
 
 import java.util.Comparator;

public class Module6BubbleSort {

    // Bubble sort using Comparable
    public static <T extends Comparable<T>> void bubbleSortComparable(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Bubble sort using Comparator
    public static <T> void bubbleSortComparator(T[] array, Comparator<T> comp) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Test code
    public static void main(String[] args) {

        Integer[] numbers = { 5, 3, 8, 1, 2 };
        System.out.println("Original Integer array:");
        printArray(numbers);

        bubbleSortComparable(numbers);
        System.out.println("Sorted Integer array (Comparable):");
        printArray(numbers);

        String[] words = { "apple", "orange", "banana", "kiwi" };
        System.out.println("\nOriginal String array:");
        printArray(words);

        Comparator<String> reverse = new Comparator<String>() {
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        };

        bubbleSortComparator(words, reverse);
        System.out.println("Sorted String array (reverse):");
        printArray(words);

        Comparator<String> byLength = new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        };

        bubbleSortComparator(words, byLength);
        System.out.println("Sorted String array (by length):");
        printArray(words);
    }
}
