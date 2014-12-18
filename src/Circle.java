import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**Description: This Circle class inherits from it's parent class Shape
 * which has the basic functionalities for a general shape. However,
 * this Circle class is modified specifically to be implemented for 
 * a circle therefore, many of the functions or methods in the parent class
 * are overwritten to complement the Circle class. 
 * 
 * An example of this would be all shapes have an area so it is suitable
 * to have a function in the parent class that sets or gets the area of shape
 * however, the area of all shapes are NOT equivalent to ((3.14...)r^2). This equation is only
 * suitable for a circle hence the Circle class will override the parent class getArea() 
 * function. This example applies to all different subclasses inheriting from a parent class.
 * Plus the Shape class is very generic and dosn't do much anyways, it is simply a frame for
 * us to work with so we don't have to repeat redundant code. 
 * Project: Circle.java
 * @author shayanraouf
 */
public class Circle extends Shape{
	
	 private double radius; //initialization of private fields 
	 
	 /**This Circle constructor accepts an argument in
	  * its parameter and calls the parent class to initialize
	  * its x and y coordinates*/
	 public Circle(int x, int y, double r){
		 super(x, y);//call constructor
		 setRadius(r);
	 }
	
	/**This method computes the area 
	 * and @returns the area of the circle
	 * of type double*/
	public double getArea(){
		
		//In mathematical notation this is computing ((3.14...)r^2)
		double area = Math.PI * (this.radius * this.radius);
		return area;
		
	}
	
	/**This method takes in a Graphics g as an argument and
	 * will draw the shape onto the Graphics context g or g2D*/
	public void draw(Graphics g){
		
		//checks for null and instance of the Graphics class
		if(g != null && g instanceof Graphics){
		Graphics2D g2d = (Graphics2D)g;
		
		int x = getX();
	    int y = getY();
		
		 
		g2d.setColor( Color.GREEN );//sets the color to green
		//we draw using drawlOval but because the radius is 
		//given twice as height & weight a circle is the result
	    g2d.drawOval(x, y, (int)this.radius, (int)this.radius);
		}
		else{
			
			//prints error message if invalid args
			System.err.println("Paramater is either null or not an instance of Graphics class");
		}

	}
	
	/**This accessor method @returns 
	 * the radius of type double */

	public double getRadius(){
		return radius;
		
	}
	
	/**This method accepts an argument of type
	 * double to initialize the radius*/
	public void setRadius(double radius){	
		this.radius = radius;
		
	} 
	
	public int compareTo(Circle o){
		if(o.getArea() == getArea()){
			return 0;
		}
		else{
			return -1;
		}
	}
	@Override 
	public Circle clone(){
		return new Circle(getX(), getY(), radius);
	}
	
	public String toString(){
		return super.toString() + "Circular";
	}
	
}
