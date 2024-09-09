public class Main {

	public static void main(String[] args) {
		StorageBox<String> s = new StorageBox<String>("I love Data Structures!");
		StorageBox<Integer> i = new StorageBox<Integer>(10);
		StorageBox<Double> d = new StorageBox<Double>(10.5);
		
		System.out.println(s.toString());
		System.out.println(s.isEmpty());
		System.out.println(i.toString());
		System.out.println(i.isEmpty());
		System.out.println(d.toString());
		System.out.println(d.isEmpty());
		
		
		
	}

}
