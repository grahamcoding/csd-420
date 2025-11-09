/**
 * Daniel Graham
 * Module 4 LinkedList
 * 11/09/2025
 */
 
 /**
Results Discussion

Traversing a LinkedList using the Iterator is immensely faster.
Iterator accesses each node of the list sequentially.
get(index) starts at the beginning of the list and walks through nodes one by one, 
until it reaches the "i" element.

In terms of real world results, the iterator method can complete in miliseconds,
but the get(index) method can take hundreds of times longer to complete, the difference
between the two growing as the size of the list grows!
*/

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversalTest {
    public static void main(String[] args) {
        // Test with 50,000 integers
        testTraversalTime(50000);

        // Test with 500,000 integers
        testTraversalTime(500000);
    }

    // Method to test traversal time for a given number of elements
    public static void testTraversalTime(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the LinkedList with integers
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        System.out.println("\n--- Testing with " + size + " integers ---");

        // Traverse using Iterator
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        long iteratorTime = endTime - startTime;
        System.out.println("Time using Iterator: " + iteratorTime + " ms");

        // Traverse using get(index)
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long getTime = endTime - startTime;
        System.out.println("Time using get(index): " + getTime + " ms");

        // Print the difference
        System.out.println("Difference: " + (getTime - iteratorTime) + " ms");
    }
}

