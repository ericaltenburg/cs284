package classses;

public abstract class Shape implements Colorable {
	// Data fields
	private String color;

	// Constructors
	/**
	 * Constructs a new shape given a color
	 * @param color The color of the shape
	 */
	Shape(String color) {
		this.color=color;
	}
	
	
	// Methods
	/**
	 * This method returns the color
	 * @return The color of the shape
	 */
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	@Override
	public String toString() {
		return "My color is: "+ this.color;
	}
	
	public String getInfo() {
		return "color is "+color;
	}
	
	public abstract double area();
	
	
//	public String m() {
//		return "Shape";
//	}
		

}
