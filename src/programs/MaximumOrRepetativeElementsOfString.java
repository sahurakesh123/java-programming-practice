package programs;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

public class MaximumOrRepetativeElementsOfString {
	public static void main(String args[]) {
		String a  = "Rakesh Sahu"; //a is most repetitive first occurrence of char
		Set<Integer> rep = new HashSet<>();
		OptionalInt res1 = a.chars().filter(i->rep.add(i)).findFirst();
		System.out.println((char)res1.getAsInt());
		
	
	
	}
	
}
