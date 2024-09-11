import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@org.junit.jupiter.api.Test
	void String() {
		StorageBox<String> s = new StorageBox<String>("I love Data Structures!");
		assertEquals(s.getItem(), s);
	}
	
	@org.junit.jupiter.api.Test
	void Double() {
		StorageBox<Double> d = new StorageBox<Double>(10.5);
		assertEquals(d.getItem(), d);
	}
	
	

}
