package programs.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RemoveTextAndAddSumOfNumbers {
	//Program to remove string from above array elements & calculate sum.
	public static void main(String args[]) {
		List<String> list = Arrays.asList("Dff56", "68ghb77", "jgg366"); 
		
		Optional<Integer> res = list.stream().map(s->s.replaceAll("[a-z A-Z]" ,""))
				.map(s -> Integer.parseInt(s))
				.reduce(Integer::sum);
		
		System.out.println(res.get());
	}
}
