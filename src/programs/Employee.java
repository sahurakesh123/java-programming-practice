package programs.java8;

import java.time.LocalDate;
import java.util.Date;

public class Employee {

	
	private String name;
	private Integer age;
	private String gender; 
	private String dept;
	private Double salary;
	private LocalDate  joiningDate;
	
	public LocalDate  getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate  joiningDate) {
		this.joiningDate = joiningDate;
	}

	 static Employee create( String name, int age ) { 
		 Employee p = new Employee();
	      p.name = name;
	      p.age = age;
	      return p;
	  }	
	 
	public Employee(String name, Integer age, String gender, String dept, Double salary, LocalDate  joiningDate) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dept = dept;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	public Employee() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
