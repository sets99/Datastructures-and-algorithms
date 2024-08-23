package Student;

public class Main {

	public static void main(String[] args) {
		Student student = new Student("Saksham", "Sethi", "12345");
		
		System.out.println("First Name: " + student.getFname());
		System.out.println("Last Name: " + student.getLname());
		System.out.println("Student ID: " + student.getStudentID());
		
		student.addTestScore(80);
		student.addTestScore(95);
		student.addTestScore(100);
		student.addTestScore(76.6);
		student.addTestScore(85);
		student.addTestScore(98.3);
	
		System.out.println("Saksham's average score is " + student.getAverageScore());
		System.out.println("Saksham's letter grade in the class is " + student.getLetterGrade());
		
		for(int i = 0; i <= 5; i++) {
			System.out.println(student.getScore(i));
		}
	}

}
