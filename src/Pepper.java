import java.awt.Color;

/**Description: 
 * @author shayanraouf*/
public class Pepper extends Vegetable{

	/**Constructor sets the description, cost to $0.17 and 13 calories*/
	public Pepper(){
		super("Pepper", new Money(0,17), 13, Color.GREEN);
	}
	
	public String toString(){
		return super.toString() + "Green";
	}
	
}

