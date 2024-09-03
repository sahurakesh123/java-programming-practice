package programs.java8;

import java.time.LocalDate;

public class Employee implements Comparable<Object>{

	
	private String name;
	private Integer age;
	private String gender; 
	private String dept;
	private Double salary;
	LocalDate  joiningDate;
	private String city;
	
	public Employee(String name, Integer age, String gender, String dept, Double salary, LocalDate joiningDate,
			String city) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dept = dept;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

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

	@Override
	public String toString() {
		return "\nEmployee [name=" + name + ", age=" + age + ", gender=" + gender + ", dept=" + dept + ", salary="
				+ salary + ", joiningDate=" + joiningDate + "]";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((joiningDate == null) ? 0 : joiningDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (joiningDate == null) {
			if (other.joiningDate != null)
				return false;
		} else if (!joiningDate.equals(other.joiningDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}


	@Override
	public int compareTo(Object o) {
		return this.compareTo(o);
	}
}
