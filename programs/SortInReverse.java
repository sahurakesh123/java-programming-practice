package programs;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortInReverse {

	public static void main(String[] args) {
		//inputArrayList= [1,3,2,4,3,1,2]
		//outputArrayList = [4,3,2,1]
		List<Integer> list = Arrays.asList(1,3,2,4,3,1,2);
		System.out.println(list);
		list = list.stream()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		System.out.println(list);
		
		

	}

}
