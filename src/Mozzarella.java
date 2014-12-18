/**Description:This set of classes will be used to decorate Pizza Objects.  
 * They’ll manage their cost and calorie count per serving, as well as define
 * some custom characteristics (read member variables) like Colors for the 
 * Vegetable subclass.  Before starting on the code, be sure to check out the
 * inheritance hierarchy at the beginning of this assignment(@Rob Nash)
 * @author shayanraouf*/
public class Mozzarella extends Cheese{
	/**Constructor sets the description, cost to $5.50 and 700 calories*/
	public Mozzarella(){
		super("Mozzarella", new Money(5,50), 700);
	}

}