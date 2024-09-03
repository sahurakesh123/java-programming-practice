package programs.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeRelatedAllOperation {

	
	
	
	public static void main(String[] args) {
		Employee e1 = new Employee("rakesh", 38, "M", "IT", 28d,  LocalDate.of(2008,12,05));
		Employee e2 = new Employee("naresh", 36, "M", "IT", 23d,  LocalDate.of(2009,12,04));
		Employee e3 = new Employee("rekha", 33, "F", "ED", 21d,  LocalDate.of(2022, 11,02));
		Employee e4 = new Employee("rashmi", 34, "F", "Home", 24d,  LocalDate.of(2018,11,04));
		Employee e5 = new Employee("angel", 17, "F", "School", 37d, LocalDate.of(2017,05,06));
		Employee e6 = new Employee("Rudransh", 14, "M", "School", 36d,  LocalDate.of(2014, 06,06));
		Employee e7 = new Employee("Reyansh", 21, "M", "School", 39d,  LocalDate.of(2012, 07,03));
		
		List<Employee> emplist = new ArrayList<>();
		emplist.add(e1);
		emplist.add(e2);
		emplist.add(e3);
		emplist.add(e4);
		emplist.add(e5);
		emplist.add(e6);
		emplist.add(e7);
	
	//Emp by dept name 
	 emplist.stream().collect(Collectors.groupingBy(Employee::getDept))
				.forEach((k,v)-> System.out.println("Dept: " +k +v));
	 System.out.println("---------------------------------------------");
	 emplist.forEach(e -> System.out.println(e.getName()));
	 emplist.sort(Comparator.comparing(Employee::getName));
	// Optional<Employee> mostExpEmp = emplist.stream().sorted(Comparator.comparing(Employee::getJoiningDate)).findFirst();
	 System.out.println("After Sorting --- ");
	 emplist.forEach(e -> System.out.println(e.getName()));
	 System.out.println("---------------------------------------------");
	 System.out.println();
	 
		Map<String, Long> allMaleFemaleEmpCount = emplist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(allMaleFemaleEmpCount);
		
		//Print all dept of org
		emplist.stream().map(Employee::getDept).distinct().forEach(System.out::println);
		
		//Average age of male and female emp
		Map<String, Double> averageAgeOFMaleFemale = emplist.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(averageAgeOFMaleFemale);
		
		//Highest paid employee
		Employee highestPaidEmp = emplist.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
		System.out.println(highestPaidEmp.getName()+" :Dept -"+ highestPaidEmp.getDept());
		
		//Who joined after 2015
		emplist.stream().filter(e -> e.getJoiningDate().getYear() >2015 ).map(Employee::getName).forEach(System.out::println);
		
		//Youngest male emp from IT dept
		Optional<Employee> youngestMaleEmpoFITDept = emplist.stream().filter(e -> e.getGender().equals("M") && e.getDept().equals("IT")).min(Comparator.comparingInt(Employee::getAge));
		System.out.println(youngestMaleEmpoFITDept.get().getName());
		
		//Who has most working exp in the orgnisnation
		Optional<Employee> mostExpEmp = emplist.stream().sorted(Comparator.comparing(Employee::getJoiningDate)).findFirst();
		System.out.println("mostExpEmp : -"+mostExpEmp.get().getName());
		
		//Average and total salary of org
		Double AverageSal = emplist.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("Summaarising salary of ORG :" +AverageSal);
		
		Double totalSalary = emplist.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("Summaarising salary of ORG :" +totalSalary);
		
		//Name of all emp in each dept
		System.out.println("---------Name of all emp in each dept ---------");
		Map<String, List<Employee>> nameOfEmpDept = emplist.stream().collect(Collectors.groupingBy(Employee::getDept));
		System.out.println(nameOfEmpDept);
		System.out.println("------------------------------------------------");
		for (Entry<String, List<Employee>> employee : nameOfEmpDept.entrySet()) {
			System.out.println(employee.getKey() +" --  "+ employee.getValue() );
		}
		
		//Separate emp who are younger that 25 and later
		Map<Boolean, List<Employee>> yougerAndOldeEmp = emplist.stream().collect(Collectors.partitioningBy(e -> e.getAge()>25));
		for (Entry<Boolean, List<Employee>> employee : yougerAndOldeEmp.entrySet()) {
			if(employee.getKey()) {
				System.out.println("Emp Greater than 25");
				for (Employee employee2 : employee.getValue()) {
					System.out.println("         =="+employee2.getName());
					System.out.println("         =="+employee2.getDept());
					System.out.println("         =="+employee2.getAge());
				}
			}else {
				System.out.println("Emp Less than 25");
				for (Employee employee2 : employee.getValue()) {
					System.out.println("         =="+employee2.getName());
					System.out.println("         =="+employee2.getDept());
					System.out.println("         =="+employee2.getAge());
				}	
			}
			
		}
		
		
		//Oldest emp and his details 
		Optional<Employee> oldestEmp = emplist.stream().max(Comparator.comparingInt(Employee::getAge));
		System.out.println("oldestEmp.get().getName()"+oldestEmp.get().getName());

		//List duplicate elements
		List<Integer> listOfInt = Arrays.asList(10,29,87,10,20,76,28,80,80,90, 22);
		Set<Integer> set = new HashSet<>();
		listOfInt.stream().filter(x->!set.add(x)).forEach(x -> System.out.println(x)); 
		
		//Count the no of occurrence of words in given string
		String str = "Hare Krishna Hare Krishna, Krishna Krishna Hare Hare";
		Map<String, Long> list = Arrays.asList(str.split(" ")).stream().
				collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(list);
		
		//Before After
		Map<Boolean, List<Employee>> listMap = emplist.stream()
		        .collect(Collectors.partitioningBy(e -> e.joiningDate.isAfter(LocalDate.of(2014, 06,06))));

		List<Employee> employeeListAfter = listMap.get(true);
		List<Employee> employeeListBefore = listMap.get(false);

		System.out.println(employeeListAfter);
		System.out.println(employeeListBefore);
	}
	

}
