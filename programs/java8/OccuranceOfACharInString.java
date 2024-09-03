package programs.java8;

import java.util.function.IntPredicate;

public class OccuranceOfACharInString {

	public static void main(String[] args) {
		String s = "I like to visit Australia";
		IntPredicate adult = i -> i == 'i';
		IntPredicate adult2 = i -> i == 'I';
		long res = s.chars().filter(adult.or(adult2)).count();

		 System.out.println(res);
	}

}
