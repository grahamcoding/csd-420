/**
 * Daniel Graham
 * Module 3 ArrayList
 * 11/09/2025
 */
 
import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesExample {

// Generic method that removes duplicates from any ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>(); // new list to store unique elements
        for (E element : list) {
            if (!newList.contains(element)) { // check if element is already in newList
                newList.add(element);
            }
        }
        return newList; // return list without duplicates
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // Fill the original list with 50 random integers between 1 and 20
        for (int i = 0; i < 50; i++) {
            numbers.add(random.nextInt(20) + 1); // random number from 1 to 20
        }

        System.out.println("Original List (with duplicates):");
        System.out.println(numbers);

        // Call the generic removeDuplicates method
        ArrayList<Integer> noDuplicates = removeDuplicates(numbers);

        System.out.println("\nList after removing duplicates:");
        System.out.println(noDuplicates);
    }
}
