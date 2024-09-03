package programs.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		
		List<Integer> listOfInt = Arrays.asList(10,29,87,10,20,76,28,80,80,90, 22);
		//listOfInt.stream().mapToInt(i->i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting());

		listOfInt.stream().filter(i -> Collections.frequency(listOfInt, i)>1).distinct().collect(Collectors.toList()).forEach(System.out::println);
		

		long count = listOfInt.stream().filter(i -> Collections.frequency(listOfInt, i)>1).distinct().count();
		System.out.println("and Count is ->: "+count);

	}

}
