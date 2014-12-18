import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**Description: This Square class inherits from it's parent class Shape
 * which has the basic functionalities for a general shape. However,
 * this Square class is modified specifically to be implemented for 
 * a circle therefore, many of the functions or methods in the parent class
 * are overwritten to complement the Square class. 
 * Project: Square.java
 * @author shayanraouf
 */
public class Square extends Shape implements Cloneable{
	
	//initialization of private fields 
	private double size;
	
	/**This constructor accepts four arguments as as parameter
	 * x, y coordinates and the height & width of the Rectangle
	 * and initializes them for the given value*/
	public Square(int x, int y, double size){
		
		super(x, y); //calls the super class
		//sets the size
		setSize(size);
	}
	
	/**This method accepts an argument of 
	 * type double and initializes the height
	 * to the given value*/
	public void setSize(double size){
		this.size = size;	
	}
	
	
	/**This method @returns he height of the rectangle*/
	public double getSize(){
		return this.size;
	}
	

	
	/**This @returns the area, which length * width
	 * and length being represented by height here*/
	public double getArea(){
		return (this.size * this.size);
	}
	
	
	/**This method takes in a Graphics g as an argument and
	 * will draw the shape(Rectangle in this case) onto the Graphics context*/
	public void draw(Graphics g){

		//checks for null and instance of Graphics class
		if(g == null && !(g instanceof Graphics)) throw new PizzaException("Paramater is either null or not an instance of Graphics class");
		Graphics2D g2d = (Graphics2D)g; //casting
		//super class x & y coordinates 
		int x = getX(); 
		int y = getY();	 
		g2d.setColor( Color.BLUE ); //sets the color to blue
	    g2d.drawRect(x, y, (int)size, (int)size); //draws the square	
	
	}
	@Override
	public Square clone(){
		return new Square(getX(), getY(), size);
	}
	
	public String toString(){
		return super.toString() + "Square";
	}
	
	
}
