import java.util.*;


public class Student implements Comparable<Student>{
	private String fname;
	private String lname;
	private String studentID;
	private ArrayList<Double> testscores = new ArrayList<Double>();
	
	public Student(String fn, String ln, String id) {
		fname = fn;
		lname = ln;
		studentID = id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public void addTestScore(double score) {
		double myscore = score;
		
		if(myscore <= 0) {
			myscore = 0;
		}
		
		if(myscore >= 100) {
			myscore = 100;
		}
		
		
		testscores.add(myscore);
	}
	
	public double getScore(int index) {
		return this.testscores.get(index);
	}
	
	public double getAverageScore() {
		double sum = 0;
		
		for(int i = 0; i < testscores.size(); i++) {
			sum = sum + testscores.get(i);
		}
		
		double avg = (double) (sum)/(testscores.size());
		
		return avg;
	}
	
	public Grade getLetterGrade() {
		double avg = this.getAverageScore();
		
		
		if(avg < 60) {
			return Grade.F;
		}
		
		else if(avg < 70) {
			return(Grade.D);
		}
		
		else if(avg < 80) {
			return(Grade.C);
		}
		
		else if(avg < 90) {
			return(Grade.B);
		}
		
		else {
			return(Grade.A);
		}
	}

	@Override
	public String toString() {
		return "Student: " + lname + ", " + fname + ", id = " + "id";
	}

	@Override
	public int compareTo(Student o) {
		if(o.getLname().compareTo(lname) >= 1) {
			return -1;
		}
		
		if(o.getLname().compareTo(lname) <= -1) {
			return 1;
		}
		
		else {
			if(o.getFname().compareTo(fname) >= 1) {
				return -1;
			}
			
			if(o.getFname().compareTo(fname) <= -1) {
				return 1;
			}
			
			else {
				if(Integer.parseInt(o.studentID) > Integer.parseInt(studentID)) {
					return -1;
				}
				
				if(Integer.parseInt(o.studentID) < Integer.parseInt(studentID)) {
					return 1;
				}
				
				else {
					return 0;
				}
			}
		}
		
		
	}
}
	
	

