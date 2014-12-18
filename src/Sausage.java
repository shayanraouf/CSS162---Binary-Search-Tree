/**Description:This set of classes will be used to decorate Pizza Objects.  
 * They’ll manage their cost and calorie count per serving, as well as define
 * some custom characteristics (read member variables) like Colors for the 
 * Vegetable subclass.  Before starting on the code, be sure to check out the
 * inheritance hierarchy at the beginning of this assignment(@Rob Nash)
 * @author shayanraouf*/
public class Sausage extends Meat{

	/**Constructor sets the description, cost to $4.75 and 430 calories*/
	public Sausage(){
		super("Sausage", new Money(4,75), 430);
	}

}