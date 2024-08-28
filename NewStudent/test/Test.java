import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		Student test = new Student("FirstName", "LastName", "StudentID");
		test.addTestScore(85.0);
	
		assertEquals(85.0, test.getScore(0), .001);
	}

}
