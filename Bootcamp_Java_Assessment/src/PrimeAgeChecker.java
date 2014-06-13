package deptdata;

public class PrimeAgeChecker {

	Employee checkMe;
	int age;
	
	public static boolean PrimeAgeCheck(Employee checkMe) {
		boolean status = false;
	    
	    for (int i=2; i < checkMe.age; ++i) {
	    	if (checkMe.age % i == 0) {
	    		status = true;
	    		break;
	    	}
	    }
	    return status;	
	}
}
