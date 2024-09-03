package programs;
///6.) Java program to Reverse Number
import java.util.Scanner;

public class ReverseANumber {

	public static void main(String[] args) {
		int number, rev = 0, reminder;
		System.out.println("Enter any number : ");

		number = new Scanner(System.in).nextInt();
		
		while (number > 0) {
			reminder = number % 10;
			rev = rev * 10 + reminder;
			number = number / 10;
		}
		System.out.println("Reverse : " + rev);

	}

}
