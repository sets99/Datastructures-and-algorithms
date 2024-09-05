import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		Student test = new Student("FirstName", "LastName", "StudentID");
		test.addTestScore(85.0);
	
		assertEquals(85.0, test.getScore(0), .001);
	}
	
	@org.junit.jupiter.api.Test
	void testStudentCompareToGreater() {
		Student student = new Student("aaaaaa", "last", "12345");
		Student student2 = new Student("zzzz", "alast", "12345");
		int compare = student.compareTo(student2);
		assertTrue(compare > 0);
	}
	
	@org.junit.jupiter.api.Test
	void testStudentCompareToGreaterSameLast() {
		Student student = new Student("zzzzz", "last", "12345");
		Student student2 = new Student("aaaaa", "last", "12345");
		int compare = student.compareTo(student2);
		assertTrue(compare > 0);
	}
	
	@org.junit.jupiter.api.Test
	void testStudentCompareToLess() {
		Student student = new Student("zzzz", "alast", "12345");
		Student student2 = new Student("aaaa", "last", "12345");
		int compare = student.compareTo(student2);
		assertTrue(compare < 0);
	}
	
	@org.junit.jupiter.api.Test
	void testStudentCompareToEqual() {
		Student student = new Student("first", "last", "12345");
		Student student2 = new Student("first", "last", "12345");
		int compare = student.compareTo(student2);
		assertTrue(compare == 0);
	}
	

}
