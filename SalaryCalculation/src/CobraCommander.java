public class CobraCommander extends Employee {

	public CobraCommander(int emphours, String empname, int empbaseSalary) {
		super(emphours, empname, empbaseSalary);
	}

	@Override
	public double weeklyPay() {
		return 1;	
	}
	
	public static String toString(Employee emp) {
		return("Employee Name: " + emp.getName() + ", Weekly Pay: " + emp.weeklyPay());
	}
}

