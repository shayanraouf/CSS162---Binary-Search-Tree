/**Description:This set of classes will be used to decorate Pizza Objects.  
 * They’ll manage their cost and calorie count per serving, as well as define
 * some custom characteristics (read member variables) like Colors for the 
 * Vegetable subclass.  Before starting on the code, be sure to check out the
 * inheritance hierarchy at the beginning of this assignment(@Rob Nash)
 * @author shayanraouf
 */
public class Marinara extends Base{
	/**Constructor sets the description, cost to $0.55 and 25 calories*/
	public Marinara(){
		super("Marinara", new Money(0,55), 25);
	}
}
