package programs.java8;
import java.util.Scanner;

/**
 * Java Program to Count Vowels and Consonants in a String using Java 8 Streams
 * Author: https://www.javaguides.net/
 */
public class VowelConsonantCounterStreams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt the user for input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase(); // Convert to lowercase

        // Step 2: Count vowels using streams
        long vowelCount = input.chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();

        // Step 3: Count consonants using streams
        long consonantCount = input.chars()
                .filter(c -> c >= 'a' && c <= 'z' && "aeiou".indexOf(c) == -1)
                .count();

        // Step 4: Display the counts
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
    }
}
