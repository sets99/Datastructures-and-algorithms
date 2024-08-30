public class HighCommand extends Employee {

	public HighCommand(int emphours, String empname, int empbaseSalary) {
		super(emphours, empname, empbaseSalary);
	}

	@Override
	public double weeklyPay() {
		return this.getBaseSalary()/52;
				
	}

	public static String toString(Employee emp) {
		return("Employee Name: " + emp.getName() + ", Weekly Pay: " + emp.weeklyPay());
	}
}
