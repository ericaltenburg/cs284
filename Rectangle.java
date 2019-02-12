package classses;

public class Rectangle extends Shape{

	// Data fields
	private Integer base;
	private Integer height;
	
	private static int noOfRectangles;
	
	// Constructors
	Rectangle(int height, int base, String color) {
		super(color);
		this.height=height;
		this.base=base;		
		noOfRectangles++;
	}
		
	Rectangle (int height, int base) {
		super("Blue");
		this.height=height;
		this.base=base;
	}
	// Methods
	public int perimeter() {
		return 2*base+2*height;
	}
	
	public int getBase() {
		return base;
	}


	public void setBase(int base) {
		this.base = base;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	

	public double area() {
		return base*height;
	}
	
	@Override
	public String getInfo() {
		return "my height is "+ height + "; my base is "+base+";" +super.getInfo();
	}
	
	public void setColor(int i) {
		this.setColor("Blue");
	}

	public void setColor(double i) {
		this.setColor("Yellow");
	}
	
	public String toString() {
		return "I am a rectangle of base "
				+ base + " and height " +height + "." + super.toString();
	}
	
	public Pair<Integer,Integer> baseAndHeight() {
		return new Pair<Integer,Integer>(base,height);
	}
	
	public Pair<String,Integer> colorAndBase() {
		return new Pair<String,Integer>(this.getColor(),base);
	}

//	public static void main(String[] args) {
//		 Rectangle r = new Rectangle(2,3);
//		 Rectangle s = new Rectangle(7,5);
////		 r.setHeight(2);
////		 r.setBase(3);
//		 System.out.println("The height of r is " + r.getHeight());
//		 System.out.println("The perimeter of r is " + r.perimeter());
//		 System.out.println("The area of r is " + r.area());
//
//		 System.out.println("The perimeter of s is " + s.perimeter());
//		 System.out.println("The area of s is " + s.area());
//
//		 System.out.println("The number of rectangles created up until now is" + Rectangle.noOfRectangles);
//
//		 
//	}
}
