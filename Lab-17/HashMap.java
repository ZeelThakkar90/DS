import java.util.Arrays;
import java.util.Scanner;

// Main class to demonstrate hashing with linear probing
public class HashMap {
    static int[] hashTable = new int[20]; // hash table of size 20

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15]; // Array to store 15 input integers

        // Read 15 integers from the user and store in arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // Store elements from arr into the hash table
        store(arr);

        // Print the hash table
        System.out.println(Arrays.toString(hashTable));

        sc.close(); // Close the scanner
    }

    // Method to store elements into the hash table
    public static void store(int[] arr) {
        // Loop through each element in arr
        for (int i = 0; i < arr.length; i++) {
            // Get the hashTable index for the current element
            int index = hashFn(arr[i]);

            // Store the element at the computed hashTable index
            hashTable[index] = arr[i];
        }
    }

    // hash function to compute the index for a given number
    public static int hashFn(int n) {
        // Compute the initial hashTable index
        int index = (n % 18) + 2;

        // Handle collisions using linear probing
        if (hashTable[index] != 0) {
            // Find the next available slot
            while (hashTable[index] != 0) {
                index = (index + 1) % 20;
            }
        }

        // Return the computed index
        return index;
    }
}