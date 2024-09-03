package programs;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCharactersInString {

	public static void main(String[] args) {
		String string = "Learn Java Programming";
		duplicateCharacterCount(string); 
		System.out.println("+++++++++++++=====++++++++++++++++++");
		usingJava8(string);

	}

	private static void usingJava8(String string) {
		string.chars().mapToObj(c -> (char) c)
		  	.collect(Collectors.groupingBy(c -> c, Collectors.counting()))
		  	.forEach((k,v)->{if(v>1) {System.out.println(k + ":" + v);} });
	}

	static void duplicateCharacterCount(String inputString) {
		HashMap<Character, Integer> charCountMap = new HashMap<>();
		char[] strArray = inputString.toCharArray();
		for (char c : strArray) {
			if (charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {
				charCountMap.put(c, 1);
			}
		}
		Set<Character> charsInString = charCountMap.keySet();
		System.out.println("Duplicate Characters in : " + inputString);
		for (Character ch : charsInString) {
			if (charCountMap.get(ch) > 1) {
				System.out.println(ch + " : " + charCountMap.get(ch));
			}
		}
	}
}
