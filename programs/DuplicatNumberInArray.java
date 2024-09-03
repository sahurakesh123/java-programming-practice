package programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicatNumberInArray {
	
	public static void main(String args[]) {

		List<Integer> listOfInt = Arrays.asList(10,29,87,20,10, 20,10,20,76,28,80,80,90, 22);
		Set<Integer> set = new HashSet<>();
		//listOfInt.stream().filter(x->set.add(x)).forEach(x -> System.out.println("Way one thrugh HashSet"+x));
		
		listOfInt.stream().filter(i -> Collections.frequency(listOfInt, i)>1)
			.collect(Collectors.toSet()).forEach(System.out::println);
		
		String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
		String[] newar = Arrays.stream(myArray).filter(s -> s.length() > 4)
	      .toArray(String[]::new);
		
		for (String string : newar) {
			System.out.println(string);
		}
		
	}

}
