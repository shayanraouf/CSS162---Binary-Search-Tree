import java.awt.Color;
/**Description:This set of classes will be used to decorate Pizza Objects.  
 * They’ll manage their cost and calorie count per serving, as well as define
 * some custom characteristics (read member variables) like Colors for the 
 * Vegetable subclass.  Before starting on the code, be sure to check out the
 * inheritance hierarchy at the beginning of this assignment(@Rob Nash)
 * @author shayanraouf*/
public class Vegetable extends Ingredient{
	private static Color color;

	/**Constructor that calls the parent class
	 * sets description, cost and calories*/
	public Vegetable(String description, Money cost, int cal, Color color){
		super(description, cost, cal);
		setColor(color.getAlpha());
	}

	/**@returns a new Color*/
	public Color getColor(){
		return new Color(color.getAlpha());
		
	}
	
	/**sets the color respectively*/
	public void setColor(int rgb){
		Color setColor = new Color(rgb);
		Vegetable.color = setColor;
	}

	@Override
	public String toString(){
		return "Vegtable:" + super.toString() + " Color:";
	}

	/**@return if current color is equal to other color
	 * call to equals method in Color class*/
	public boolean equals(Color other){
		if(other == null) throw new NullPointerException(); // throw exception if null 
		if(!(other instanceof Color)) throw new PizzaException("Invalid Argument");
		return Vegetable.color.equals(other);
	}
	




}
