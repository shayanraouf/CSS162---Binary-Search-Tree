import java.awt.Color;
/**Description:This set of classes will be used to decorate Pizza Objects.  
 * They’ll manage their cost and calorie count per serving, as well as define
 * some custom characteristics (read member variables) like Colors for the 
 * Vegetable subclass.  Before starting on the code, be sure to check out the
 * inheritance hierarchy at the beginning of this assignment(@Rob Nash)
 * @author shayanraouf*/
public class Olive extends Vegetable{
		
	/**Constructor sets the description, cost to $0.36 and 52 calories*/
	public Olive(){
		super("Olive", new Money(0,36), 52, Color.BLACK);
	}
	
	public String toString(){
		return super.toString() + "Black";
	}

}