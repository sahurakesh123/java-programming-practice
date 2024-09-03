package programs.java8;

import java.util.List;

public class Reduce {

	public static void main(String[] args) {
		// COUNT
		Long count =
		    List.of(1L, 2L, 3L)
		        .stream()
		        .reduce(0L,
		                (acc, cur) -> acc + 1);
		
		System.out.println(count);
		// SUM
		Long sum =
		    List.of(1L, 2L, 3L)
		        .stream()
		        .reduce(0L,
		                (acc, cur) -> acc + cur);
		System.out.println(sum);
		
		
		// MIN
		Long min =
		    List.of(10L, 5L, 11L)
		        .stream()
		        .reduce(Long.MAX_VALUE, (acc, cur) -> acc.compareTo(cur) < 0 ? acc : cur);
		System.out.println(min);

		// MAX
		Long max =
		    List.of(10L, 5L, 11L)
		        .stream()
		        .reduce(Long.MIN_VALUE,
		                (acc, cur) -> acc.compareTo(cur) > 0 ? acc : cur);
		System.out.println(max);
	}

}
