import java.util.Comparator;

public class CompareByID implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if(Integer.parseInt(o1.getStudentID()) > Integer.parseInt(o2.getStudentID())) {
			return 1;
		}
		
		if(Integer.parseInt(o1.getStudentID()) < Integer.parseInt(o2.getStudentID())) {
			return -1;
		}
		
		else {
			return 0;
		}
	}

}
