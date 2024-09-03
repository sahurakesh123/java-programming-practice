package programs;
import java.util.Scanner;

/**
 * Java Program to Find All Permutations of a String
 * Author: https://www.javaguides.net/

* Introduction
A permutation of a string is a rearrangement of its characters. For example, the permutations of the string "ABC" are "ABC", "ACB", "BAC", "BCA", "CAB", and "CBA". This guide will show you how to create a Java program that finds and displays all permutations of a given string.

Problem Statement
Create a Java program that:

Takes a string as input.
Finds and displays all the permutations of that string.
Example 1:
Input: "ABC"
Output: ABC, ACB, BAC, BCA, CAB, CBA
Example 2:
Input: "AB"
Output: AB, BA
Solution Steps
Prompt for Input: Use the Scanner class to read a string input from the user.
Create a Recursive Method: Use a recursive method to generate all permutations of the string.
Display Each Permutation: Print each permutation as it is generated.
Java Program
Java Program to Find All Permutations of a String
 */
public class StringPermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt the user for input
        System.out.print("Enter a string to find its permutations: ");
        String input = scanner.nextLine();

        // Step 2: Generate and display permutations
        System.out.println("Permutations of the string are:");
        findPermutations(input, "");
    }

    // Step 3: Recursive method to find permutations
    public static void findPermutations(String str, String prefix) {
        if (str.isEmpty()) {
            // Base case: If the string is empty, print the prefix
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                // Choose the character at index i
                char ch = str.charAt(i);

                // Form the remaining string after removing the character at index i
                String remaining = str.substring(0, i) + str.substring(i + 1);

                // Recurse with the remaining string and the prefix updated with the chosen character
                findPermutations(remaining, prefix + ch);
            }
        }
    }
}
