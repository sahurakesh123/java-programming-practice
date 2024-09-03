package programs.java8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoinTwoList {


	public static void main(String[] args) {
		 List<Employee> listOfEmpObj1 = Arrays.asList(
                 Employee.create("Oscar", 0x20),
                 Employee.create("Reyes", 0x30),
                 Employee.create("Java", 0x10)
         );
		 
		 List<Employee> listOfEmpObjects2 = Arrays.asList(
                 Employee.create("Naresh", 0x20),
                 Employee.create("Rakesh", 0x30),
                 Employee.create("Java", 0x10)
         );
		
		 System.out.println("--------------------------------------------------------");
		 System.out.println("If any name contains/matched in list2 of list1 ----"+
				 listOfEmpObj1.stream().map(Employee::getName)
				 .anyMatch(listOfEmpObjects2.stream().map(Employee::getName)
						 .collect(Collectors.toSet())::contains));
		 System.out.println("--------------------------------------------------------");
		 
		 
		 System.out.println("--------------------------------------------------------");
		 boolean var = listOfEmpObj1.stream().anyMatch(element -> listOfEmpObjects2.contains(element));
		 System.out.println("Comparison of Objects of 2 list ---"+var);
		 System.out.println("--------------------------------------------------------");
		 System.out.println();
		 
		 
		 System.out.println("------1#Sorting by name, a list with stream.sorted() in Java----");
		 listOfEmpObjects2.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		 System.out.println("sorted list - >"+listOfEmpObjects2);
		 //OR
		 Collections.sort(listOfEmpObjects2,((e1,e2)->e1.getName().compareTo(e2.getName())));
		 //OR
		 List<Employee> result2 = listOfEmpObj1.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		 System.out.println("sorted list1 - >"+result2);
		 System.out.println("--------------------------------------------------------");
		 System.out.println();
		 

		 List<String> listOfNames = Arrays.asList(
	                "Rakesh",
	                "Rakesh",
	                "Rakesh"
	         );
		 //2#check if all values are same in list of names 
		 System.out.println("-----2#check if all values are same in list of Names java------------");
		 boolean allEqual = listOfNames.stream().distinct().limit(2).count() <= 1;
		 System.out.println("All Equals ? -- "+allEqual);
		 System.out.println("-------------------------------------------------------------");
		 System.out.println();
		 
		 System.out.println("3#Joins two list of objects without comparing elements > Using Stream.of() + flatMap() + Collector");
		 //3#Joins two list without comparing elements > Using Stream.of() + flatMap() + Collector
		 List<Employee> list4 = Stream.of(listOfEmpObj1, listOfEmpObjects2).flatMap(x -> x.stream()).collect(Collectors.toList());
		 System.out.println(list4);
		 System.out.println();
		 System.out.println("OR");
		 //OR
		//4#Joins two list without comparing elements > Using Stream.of() + Stream.forEach()
		 List<Employee> list = new ArrayList<>();
		 Stream.of(listOfEmpObj1, listOfEmpObjects2).forEach(list::addAll);
		 System.out.println(list);
		 //OR
		 System.out.println();
		 System.out.println("OR");
		 //5#Joins two list without comparing elements 	> Using Stream.concat() + Collector
		 List<Employee> list5 =  Stream.concat(listOfEmpObj1.stream(), listOfEmpObjects2.stream()).collect(Collectors.toList());
		 System.out.println(list5);
		 System.out.println("--------------------------------------------------------------");
		 System.out.println();
		 
		 
		 System.out.println("5#Joins two list comparing elements name	> Using Stream.concat() + Collector");
		 List<Employee> result = Stream.concat(
				    listOfEmpObj1.stream()
				        .filter(h -> !listOfEmpObjects2.stream().anyMatch(s -> h.getName() == s.getName())), listOfEmpObjects2.stream()
				        )
				    .collect(Collectors.toList());
		 System.out.println(result);
		 // listone.stream().filter(two->listtwo.stream().anyMatch(one->one.equals(two).collect(Collectors.toList())));
		 System.out.println("--------------------------------------------------------------");
		 System.out.println();
		 
		 
		 
		 List<Employee> listOfEmployees = Arrays.asList(
				 Employee.create("Rakesh", 18), //(id, age)
						 Employee.create("Naresh", 24),
						 Employee.create("Rashmi", 14),
						 Employee.create("Rudra", 10)
				);

				//Same Employee can place multiple purchases.
		List<PurchaseOrder> purchaseOrdersList = Arrays.asList(
				    new PurchaseOrder("Rakesh", 24), //(Employee id, purchase amount)
				    new PurchaseOrder("Rakesh", 40),
				    new PurchaseOrder("Naresh", 10),
				    new PurchaseOrder("Naresh", 24),
				    new PurchaseOrder("Rashmi", 23),
				    new PurchaseOrder("Rashmi", 45),
				    new PurchaseOrder("Rudra", 68),
				    new PurchaseOrder("Rudra", 12),
				    new PurchaseOrder("Rudra", 23)
		);

		System.out.println("----------------Employee Name < 18 age------------------------");
				Set<String> employeeAgeLessThan18 = listOfEmployees.stream()
				    .filter(Employee -> Employee.getAge() < 18)
				    .map(Employee::getName)
				    .collect(Collectors.toSet());
		System.out.println(employeeAgeLessThan18);
	    System.out.println("--------------------------------------------------------------");
		System.out.println();
		
		System.out.println("-------Average of amount of matched by name from first listOfObject and purchased order list");
		OptionalDouble average = purchaseOrdersList.stream()
					.filter(p -> employeeAgeLessThan18.contains(p.getName()))
					.mapToInt(PurchaseOrder::getAmount)
					.average();
		System.out.println(average);
		System.out.println("--------------------------------------------------------------");
		System.out.println();

		
		System.out.println("-------filter Names conatains in one list if yes print objects -------");
		List<PurchaseOrder> listt = purchaseOrdersList.stream()
				    .filter(p -> employeeAgeLessThan18.contains(p.getName())).collect(Collectors.toList());
		System.out.println(listt);
		System.out.println("--------------------------------------------------------------");
		System.out.println();

				//https://stackoverflow.com/questions/36870225/java-8-merge-two-list-of-objects-by-id
	}
	
	
}
