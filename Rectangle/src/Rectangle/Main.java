package Rectangle;

public class Main {

	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(10,10);
		Rectangle rectangle2 = new Rectangle(12, 10);
		
		System.out.format("Rectangle Count: %d%n", Rectangle.getCount());
		System.out.format("Rectangle Count: %d%n", Rectangle.getCount());
		System.out.format("Rectangle Area: %4.2f%n", rectangle1.getArea());
		System.out.format("Rectangle Area: %4.2f%n", rectangle2.getArea());
		
	}

}
