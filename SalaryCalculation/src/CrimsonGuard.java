public class CrimsonGuard extends Employee {

	public CrimsonGuard(int emphours, String empname, int empbaseSalary) {
		super(emphours, empname, empbaseSalary);
	}

	@Override
	public double weeklyPay() {
		return(this.getBaseSalary()/52 + (this.getHours()-40)*25);
				
	}
	
	public static String toString(Employee emp) {
		return("Employee Name: " + emp.getName() + ", Weekly Pay: " + emp.weeklyPay());
	}
}
