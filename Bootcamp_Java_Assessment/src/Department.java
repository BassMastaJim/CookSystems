package deptdata;

import java.util.*;

public class Department {
	private List<String> department = Arrays.asList("Accounting","Marketing","Human Resources","Information Systems");
	private ArrayList<Employee> employees;
	private String deptName;
	
	Department(String deptName) {
		
		boolean contains = false;
		
		for (String name : department){
			if(deptName.equalsIgnoreCase(name)) {
				contains = true;
				break;
			}
		}
		if(contains) {
			this.deptName = deptName;
			this.employees = new ArrayList<Employee>();
		}
	}
	public void addEmployee(Employee a){
		// Do prime number checking before adding emp to list
		if(deptdata.PrimeAgeChecker.PrimeAgeCheck(a)) {
			a.isPrime = true;
		}
		
		if (employees.isEmpty()) {
			employees.add(a);
		} else {
			int i;
			for(i=0; i<employees.size(); ++i){
				if (employees.get(i).empAge() > a.empAge()) {
					employees.add(i,a);
					break;
				}
			}
			if (i == employees.size()) {
				employees.add(a);
			}
		}
	}
	
	public String returnByAge() {
		StringBuffer txtBlock = new StringBuffer();
		// match emp name with dep, age and if prime number and return object
		for(Employee empInfo : employees){
			txtBlock.append(deptName);
			txtBlock.append("\t");
			txtBlock.append(empInfo.name);
			txtBlock.append("\t");
			txtBlock.append(empInfo.age);
			txtBlock.append("\t");
			txtBlock.append(empInfo.isPrime);
			txtBlock.append("\n");
		}
		return txtBlock.toString();
	}
	
}
