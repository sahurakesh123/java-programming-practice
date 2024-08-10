package programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrencesOfEachWords {

	public static void main(String[] args) {
		String string = "Test Automation Java Automation";
		CharacterCount(string);
		
		//Map<String, Integer> list = Arrays.asList(string).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
		Map<String, Long> collect =   Arrays.asList(string).stream()
		          .collect(Collectors.groupingBy(Function.<String>identity(), 
		                  Collectors.<String>counting()));
		System.out.println(collect);
	}

	static void CharacterCount(String inputString) {
		HashMap<String, Integer> charCountMap = new HashMap<>();
		for (String s : inputString.split(" ")) {
			if (charCountMap.containsKey(s)) {
				charCountMap.put(s, charCountMap.get(s) + 1);
			} else {
				charCountMap.put(s, 1);
			}
		}
		System.out.println("Count of Words in a given string : " + charCountMap);
	}
}
