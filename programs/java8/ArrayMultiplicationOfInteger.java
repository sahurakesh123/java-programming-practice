package programs.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayMultiplicationOfInteger {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,4,3,5);
		Integer res =  list.stream().reduce((a,b)->a*b).get();
		System.out.println(res);
		//list.stream().filter(i-> i*i).collect(Collectors.toList());
	}

}
