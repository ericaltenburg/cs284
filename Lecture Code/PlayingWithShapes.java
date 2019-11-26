package classses;

import java.util.Arrays;

public class PlayingWithShapes {

	
	public static void myPrint (Shape s) {
		System.out.println(s);
	}
	
	public static void printColors(Colorable[] ss ) {
		for (Colorable s:ss) {
			System.out.println(s.getColor());
		}
	}


	public static void main (String[] args) {
		Rectangle r = new Rectangle(3,5);
		Circle c1 = new Circle(3.5, "Red");
		Circle c2 = new Circle(12.5);
		Square sq = new Square(4);
		
		Shape[] ss = new Shape[4];
		ss[0] = r;
		ss[1] = c1;
		ss[2] = c2;
		ss[3] = sq;
		
		printColors(ss);
		
		Fruit[] fs = new Fruit[3];
		fs[0] = new Apple("Red",3);
		fs[1] = new Orange("Orange",2);
		fs[2] = new Apple("Green",4);
		
		printColors(fs);
		
//		System.out.println(r.baseAndHeight().getFst());
//		System.out.println(r.colorAndBase().getFst());

			
//		System.out.println("The height of r is: "+r.getHeight());
//		System.out.println("The color of r is: "+r.getColor());
//		System.out.println("The radius of c1 is: "+c1.getRadius());
//		System.out.println("The color of c2 is: "+c2.getColor());
		
//		r.setColor("Green");
//		r.setColor(3.0);
//		myPrint(r);
//		myPrint(c1);
	}
}
