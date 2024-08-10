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
		 List<Employee> list1 = Arrays.asList(
                 Employee.create("Oscar", 0x20),
                 Employee.create("Reyes", 0x30),
                 Employee.create("Java", 0x10)
         );
		 
		 List<Employee> list2 = Arrays.asList(
                 Employee.create("Naresh", 0x20),
                 Employee.create("Rakesh", 0x30),
                 Employee.create("Java", 0x10)
         );
		 List<String> list3 = Arrays.asList(
                 "Rakesh",
                "Rakesh",
                "Rakesh"
         );
		 
		 System.out.println(
				 list1.stream().map(Employee::getName)
				 .anyMatch(list2.stream().map(Employee::getName)
						 .collect(Collectors.toSet())::contains));
		 
		 boolean var = list1.stream().anyMatch(element -> list2.contains(element));
		 System.out.println(var);
		 
		 //1#Sorting a list with stream.sorted() in Java
		  list2.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		  System.out.println("sorted list - >"+list2);
		  
		  Collections.sort(list2,((e1,e2)->e1.name.compareTo(e2.name)));
		 //============or====================
		  List result2 = list1.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		  System.out.println("sorted list1 - >"+result2);
		 
		 //2#check if all values are same in list java
		 boolean allEqual = list3.stream().distinct().limit(2).count() <= 1;
		 System.out.println("All Equals- "+allEqual);
		 
		 //3##Joins two list without comparing elements > Using Stream.of() + flatMap() + Collector
		 List<Employee> list4 = Stream.of(list1, list2).flatMap(x -> x.stream()).collect(Collectors.toList());
		 System.out.println(list4);
		 
		//4#Joins two list without comparing elements > Using Stream.of() + Stream.forEach()
		 List<Employee> list = new ArrayList<>();
		 Stream.of(list1, list2).forEach(list::addAll);
		 System.out.println(list);
		 
		 //5#Joins two list without comparing elements 	> Using Stream.concat() + Collector
		 List<Employee> list5 =  Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
		 System.out.println(list5);
		 
		OptionalDouble listone;
		OptionalDouble listtwo;
		//5#Joins two list comparing elements 	> Using Stream.concat() + Collector
		// listone.stream().filter(two->listtwo.stream().anyMatch(one->one.equals(two).collect(Collectors.toList())));
	//------------------------------------------------------	 
		 List<Employee> result = Stream.concat(
				    list1.stream()
				        .filter(h -> !list2.stream()
				            .anyMatch(s -> h.name == s.name)),
				        list2.stream())
				    .collect(Collectors.toList());
		 System.out.println(result);
		 
	//------------------------------------------------------	 
		 
		 List<Employee> Employees = Arrays.asList(
				 Employee.create("Rakesh", 18), //(id, age)
						 Employee.create("Naresh", 24),
						 Employee.create("Rashmi", 14),
						 Employee.create("Rudra", 10)
				);

				//Same Employee can place multiple purchases.
				List<PurchaseOrder> purchaseOrders = Arrays.asList(
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

				Set<String> EmployeeIds = Employees
				    .stream()
				    .filter(Employee -> Employee.getAge() < 18)
				    .map(Employee::getName)
				    .collect(Collectors.toSet());

				OptionalDouble average = purchaseOrders
				    .stream()
				    .filter(purchaseOrder -> EmployeeIds.contains(purchaseOrder.getName()))
				    .mapToInt(PurchaseOrder::getAmount)
				    .average();
				
				System.out.println(average);
				
				List<PurchaseOrder> listt = purchaseOrders
					    .stream()
					    .filter(purchaseOrder -> EmployeeIds.contains(purchaseOrder.getName())).collect(Collectors.toList());
				
				System.out.println(listt);
				//https://stackoverflow.com/questions/36870225/java-8-merge-two-list-of-objects-by-id
	}
	
	
}
