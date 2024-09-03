package programs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MaximumOrRepetativeElementsInStringArray {
	public static void main(String args[]) {
		String[] arr = {"apple","apple","apple", "banana", "orange", "banana","grape"};
		extractedStreamSe(arr);
		extractedStream2(arr);
		extractedMapCountOfEachElement(arr);
	}

	private static void extractedMapCountOfEachElement(String[] arr) {
		Map<String, Integer> map = new  HashMap<String, Integer>();
		
		for (String string : arr) {
			if(!map.containsKey(string)) {
				map.put(string, 1);
			}else {
				map.put(string, map.get(string)+1);
			}
		}
	}

	private static void extractedStream2(String[] arr) {
		Optional<String> res = Arrays.asList(arr).stream().max(String::compareToIgnoreCase);
		System.out.println(res.get());
	}
	
	private static void extractedStreamSe(String[] arr) {

        String string = Arrays.asList(arr).stream().max((String s1, String s2)->s2.compareTo(s1)).get();
		System.out.println("Compare list of repeatative words(most repeatative element in list)-: "+string);
	}
	
	
	
	
}
