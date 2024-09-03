package programs.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharactersInString {

	public static void main(String[] args) {
		String string = "Learn Java Programming";
		duplicateCharacterCount(string); 
		System.out.println("+++++++++++++=====++++++++++++++++++");
		usingJava8(string);
		
		/////////////////////////////////////////////////////////////////////////////////
		String input = "programming";

        // Step 1: Convert the String to a Stream of Characters
        Map<Character, Long> duplicateChars = input.chars()
                .mapToObj(c -> (char) c)  // Convert each int to a char
                // Step 2: Group characters and count occurrences
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                // Step 3: Filter out characters with only one occurrence
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                // Step 4: Collect the results into a Map
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Step 5: Output the result
        System.out.println("Duplicate Characters: " + duplicateChars);
        //////////////////////////////////////////////////////////////////////////////
        
        String input2 = "java";

        // Step 1: Create a Map to store character counts
        Map<Character, Integer> characterCountMap = new HashMap<>();

        // Step 2: Iterate over the string and update the counts in the Map
        input2.chars()
                .mapToObj(c -> (char) c)  // Convert each int to a char
                .forEach(ch -> characterCountMap.merge(ch, 1, Integer::sum)); // Merge counts

        // Step 3: Filter out characters with only one occurrence
        Map<Character, Integer> duplicateChars2 = characterCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Step 4: Output the result
        System.out.println("Duplicate Characters: " + duplicateChars2);
        ///////////////////////////////////////////////////////////////////////
        
        
        String input3 = "abcdabc";

        // Step 1: Convert the String to a Stream of Characters and collect to a Map
        Map<Character, Integer> duplicateChars3 = input3.chars()
                .mapToObj(c -> (char) c)  // Convert each int to a char
                .collect(Collectors.toMap(
                        Function.identity(),  // The key is the character
                        c -> 1,  // The initial count is 1
                        Integer::sum  // Merge counts by summing them up
                ));

        // Step 2: Filter out characters with only one occurrence
        Map<Character, Integer> filteredDuplicateChars = duplicateChars3.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Step 3: Output the result
        System.out.println("Duplicate Characters: " + filteredDuplicateChars);
        
        ////////////////////////////////////////////////////////////////////
        
	}

	private static void usingJava8(String string) {
		string.chars()
			.mapToObj(c -> (char) c)
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
