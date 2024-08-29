import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
	//	Student student = new Student("Saksham", "Sethi", "12345");
		
	//	System.out.println("First Name: " + student.getFname());
	//	System.out.println("Last Name: " + student.getLname());
	//	System.out.println("Student ID: " + student.getStudentID());
		
	//	student.addTestScore(80);
	//	student.addTestScore(95);
	//	student.addTestScore(100);
	//	student.addTestScore(76.6);
	//	student.addTestScore(85);
	//	student.addTestScore(98.3);
	
	//	System.out.println("Saksham's average score is " + student.getAverageScore());
	//	System.out.println("Saksham's letter grade in the class is " + student.getLetterGrade());
		
	//	for(int i = 0; i <= 5; i++) {
	//		System.out.println(student.getScore(i));
	//	}
		
		ArrayList<Student> arr = new ArrayList<Student>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("studentGrades.csv"))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {
				
				Student student = new Student(line.split(",")[0], line.split(",")[1], line.split(",")[2]);
				for(int i = 3; i < line.split(",").length; i++) {
					student.addTestScore(Double.parseDouble(line.split(",")[i]));
				}
				
				arr.add(student);
				
			}
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//BELOW IS FOR BUFFEREDWRITER
		try (BufferedWriter wr = new BufferedWriter(new FileWriter("studentprint.txt"))) {
			for(int i = 0; i < arr.size(); i++) {
				wr.write(arr.get(i).getStudentID() + "," + arr.get(i).getAverageScore() + "," + arr.get(i).getLetterGrade());
				wr.newLine();
			}
			
			wr.close();
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
