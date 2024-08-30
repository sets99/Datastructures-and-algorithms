public class CobraTrooper extends Employee {

	public CobraTrooper(int emphours, String empname, int empbaseSalary) {
		super(emphours, empname, empbaseSalary);
	}

	@Override
	public double weeklyPay() {
		if(this.getHours() <= 40) {
			return this.getHours() * 12;
		}
		
		else {
			return 40 * 12 + (this.getHours() - 40) * 25;
		}
				
	}
	
	public static String toString(Employee emp) {
		return("Employee Name: " + emp.getName() + ", Weekly Pay: " + emp.weeklyPay());
	}
}
