import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
	
		
		ArrayList<Student> arr = new ArrayList<Student>();
		arr = loadStudents();
		Collections.sort(arr);
		
		try (BufferedWriter wr = new BufferedWriter(new FileWriter("SortByName.txt"))) {
			for(int i = 0; i < arr.size(); i++) {
				wr.write(arr.get(i).getLname() + "," + arr.get(i).getAverageScore());
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
		
		Collections.sort(arr, new CompareByID());
		
		try (BufferedWriter wr = new BufferedWriter(new FileWriter("SortByID.txt"))) {
			for(int i = 0; i < arr.size(); i++) {
				wr.write(arr.get(i).getStudentID() + "," + arr.get(i).getAverageScore());
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
		
		Collections.sort(arr, new CompareByAverageThenName());
		
		try (BufferedWriter wr = new BufferedWriter(new FileWriter("SortByAverageThenName.txt"))) {
			for(int i = 0; i < arr.size(); i++) {
				wr.write(arr.get(i).getLname() + "," + arr.get(i).getAverageScore());
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
	
	public static ArrayList<Student> loadStudents(){
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
		
		return arr;
	}

}
