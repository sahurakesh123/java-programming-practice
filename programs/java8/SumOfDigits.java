package programs.java8;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        // Creating a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        String number = scanner.nextLine();
        scanner.close(); // Closing the scanner

        // Calculating the sum of digits
        int sum = number.chars() // Creating an IntStream of chars (ASCII values)
                         .map(Character::getNumericValue) // Converting each ASCII value to its numeric value
                         .sum(); // Summing up the numeric values

        // Displaying the sum of the digits
        System.out.println("The sum of the digits is: " + sum);
    }
}