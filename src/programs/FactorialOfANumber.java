package programs;
//5.) Java program to Find Factorial on given Number
import java.util.Scanner;

public class FactorialOfANumber {

	public static void main(String[] args) {
		int factorial =1; 
		
		System.out.print("Enter any number "); 
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		
		for (int i = 1; i <= number; i++){
			factorial = factorial * i; 
		}
			System.out.println("Factorial number is :" +factorial); 
		}

	}

