package programs;
//10.)  Java program to calculate the sum of digits of a number 
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author Rakesh.Sahu
 *
 */
public class SumOfDigitsOfNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int number = 12345;
		int sumOfDigits = calculateSumOfDigits(number);
		System.out.println("Sum of digits of " + number + " is: " + sumOfDigits);
		
		System.out.println("usingJava8: "+usingJava8(number));
	}

	public static int usingJava8(int number) {

		return (int) Stream.of(String.valueOf(number).split(""))
                .collect(Collectors.summarizingInt(Integer::parseInt))
                .getSum();

	}

	public static int calculateSumOfDigits(int number) {
		int sum = 0; while (number > 0) { 
			int digit = number % 10; 
			// Extract the last digit 
			sum = sum + digit; 
			// Add the digit to sum 
			number = number / 10; 
			// Remove the last digit from number 
			} 
		return sum; 
		
/*
 * 
Suppose, we have to find the sum of digits of the number (N) 674.


First iteration

674 % 10 = 4

Sum = 0 + 4 = 4

674 / 10 = 67

Second iteration

67 % 10 = 7

Sum = 4 + 7 = 11

67 / 10 = 6

Third iteration

6 % 10 = 6

Sum = 11 + 6 = 17

6 / 10 = 0
*/

	}
}