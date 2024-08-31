public abstract class Employee {
	int hours;
	String name;
	int baseSalary;
	
	public Employee(int emphours, String empname, int empbaseSalary) {
		hours = emphours;
		name = empname;
		baseSalary = empbaseSalary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBaseSalary() {
		return this.baseSalary;
	}
	
	public int getHours() {
		return this.hours;
	}
	
	public abstract double weeklyPay();
}
