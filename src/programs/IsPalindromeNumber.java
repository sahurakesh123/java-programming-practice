package programs;
//9.) Java program to find Palindrome number  1001 =1001
import java.util.Scanner;

public class IsPalindromeNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
		if (isPalindrome(number)) {
			System.out.println(number + " is a palindrome.");
		} else {
			System.out.println(number + " is not a palindrome.");
		}
	}

	public static boolean isPalindrome(int num) {
		int originalNumber = num;
		int reversedNumber = 0;
		while (num != 0) {
			int digit = num % 10;
			reversedNumber = reversedNumber * 10 + digit;
			num = num / 10;
		}
		return originalNumber == reversedNumber;
	}
}
