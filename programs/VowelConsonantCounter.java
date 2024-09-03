package programs;
import java.util.Scanner;

/**
 * Java Program to Count Vowels and Consonants in a String
 * Author: https://www.javaguides.net/
 */
public class VowelConsonantCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt the user for input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 2: Initialize counters
        int vowels = 0, consonants = 0;
        input = input.toLowerCase(); // Convert the string to lowercase

        // Step 3: Iterate through the string and count vowels and consonants
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'a' && ch <= 'z') {  // Check if the character is a letter
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        // Step 4: Display the counts
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}