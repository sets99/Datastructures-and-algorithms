package Student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void addScoreNormalRange() {
		Student test = new Student("FirstName", "LastName", "StudentID");
		test.addTestScore(85.0);
	
		assertEquals("Score not stored correctly", 85.0, test.getScore(0), .001);
		
	}
}
