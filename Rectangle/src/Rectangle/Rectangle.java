package Rectangle;

public class Rectangle {
	private double width = 0;
	private double height = 0;
	private static int count = 0;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		System.out.println("I am alive!");
		count++;
	}
	
	Rectangle() {
		this.width = 1;
		this.height = 1;
		System.out.println("I am alive!");
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	public double getHeight() {
		return height;
	}
	
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * @param set width
	 */
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea() {
		return this.width * this.height;
	}
}
