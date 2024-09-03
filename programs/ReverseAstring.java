///1.) Java program to reverse a string /
package programs;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseAstring {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scanner.nextLine();

		reverseStringTraditional(input);
		reverseString1(input);

		reverseJava8(input);

	}

	public static void reverseJava8(String string) {

		String str = Stream.of(string).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(""));
		System.out.println("Java8 -> "+str);
	}

	private static void reverseString1(String input) {
		String reversed = new StringBuilder(input).reverse().toString();
		System.out.println("StringBuilder ->" + reversed);
	}

	private static void reverseStringTraditional(String input) {
		char ch;
		String nstr = "";
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			nstr = ch + nstr;
		}
		System.out.println("Traditional Reversed String is : " + nstr);
	}

}
