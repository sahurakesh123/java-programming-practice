package programs.java8;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostOrLeastRepetativeCharacterInString {
	public static void main(String args[]) {
		String a  = "Rakesh sahu"; //a is most/least repetitive first occurrence of char 
		Set<Integer> rep = new HashSet<>();
		OptionalInt res1 = a.chars().filter(i->!rep.add((i))).findFirst();
		System.out.println((char)res1.getAsInt());
		
		
		String firstNon = Arrays.stream(a.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(x->x.getValue()!=1)
				.findFirst().get().getKey();
			System.out.println(firstNon);
			
			


	
	}
	
}
