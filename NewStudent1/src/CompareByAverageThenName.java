import java.util.Comparator;

public class CompareByAverageThenName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getAverageScore() > o2.getAverageScore()) {
			return 1;
		}
		
		if(o2.getAverageScore() > o1.getAverageScore()) {
			return -1;
		}
		
		else {
			return o1.getLname().compareTo(o2.getLname());
			
		}
	}

}
