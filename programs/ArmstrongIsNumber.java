package programs;
//7.) Java program to find Armstrong Number
/*An Armstrong number is a positive integer that is equal to the sum of its digits, each raised to the power of their position. For example, 153 is an Armstrong number because 1^3 + 5^3 + 3^3 = 153.
 * 		1 + 125+27
 * 
 * Three-digit numbers: 0, 1, 153, 370, 371, and 407
 * Four-digit numbers: 1634, 8208, and 9474
 * */
import java.util.Scanner;

public class ArmstrongIsNumber {

	public static void main(String[] args) {
		System.out.println("Enter any number : ");
		Scanner scanner = new Scanner(System.in);
		String number = scanner.next();
		
		int  addition = 0;
		for (int i = 0; i < number.length();){
		    char ch = number.charAt(i);
		    addition = (int) (addition + Math.pow(Character.getNumericValue(ch), number.length()));
		    i++;
		}
		
		if (addition == Integer.parseInt(number)) {
			System.out.println("Armstrong number");
		} else {
			System.out.println("Not Armstrong number");
		}
	}
}
