package deptdata;

public class Employee {
	
	public String name;
	public int age;
	public Department department;
	public boolean isPrime;
	
	 Employee(String n, int a, Department d){
		this.name = n;
		this.age = a;
		this.department = d;
		this.isPrime = false;
	}
	

	public int empAge() {
		return age;
	}
}
