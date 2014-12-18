/**Description:This set of classes will be used to decorate Pizza Objects.  
 * They’ll manage their cost and calorie count per serving, as well as define
 * some custom characteristics (read member variables) like Colors for the 
 * Vegetable subclass.  Before starting on the code, be sure to check out the
 * inheritance hierarchy at the beginning of this assignment(@Rob Nash)
 * @author shayanraouf*/
	public class Goat extends Cheese{
		/**Constructor sets the description, cost to $3.50 and 45 calories*/
		public Goat(){
			super("Goat", new Money(3,50), 45);
		}

}