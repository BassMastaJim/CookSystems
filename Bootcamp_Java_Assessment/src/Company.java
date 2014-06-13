package deptdata;

public class Company {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the different departments
		Department Accounting = new Department("Accounting");
		Department Marketing = new Department("Marketing");
		Department HR = new Department("Human Resources");
		Department InfoSys = new Department("Information Systems");
		
		// populate the different departments with the emp name, age and dep
		new Employee("Counting Guru",55,Accounting);
		new Employee("Counting Pro",45,Accounting);
		new Employee("Counting Savvy",40,Accounting);
		new Employee("Counting Novice",25,Accounting);
		new Employee("Sales Guru",50,Marketing);
		new Employee("Sales Pro",48,Marketing);
		new Employee("Sales Savvy",38,Marketing);
		new Employee("Hiring Guru",58,HR);
		new Employee("Hiring Pro",47,HR);
		new Employee("Hacking Pro",46,InfoSys);
		new Employee("Hacking Guru",51,InfoSys);
		new Employee("Hacking Savvy",38,InfoSys);
		new Employee("Hacking Novice",23,InfoSys);
		
		// Print off each department with prime number checking
		System.out.println(Accounting.returnByAge());
		System.out.println(Marketing.returnByAge());
		System.out.println(HR.returnByAge());
		System.out.println(InfoSys.returnByAge());

	}

}
