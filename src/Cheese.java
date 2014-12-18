/**Description: 
 * @author shayanraouf
 */
public class Cheese extends Ingredient{

	/**Constructor that calls the parent class
	 * sets description, cost and calories*/
	public Cheese(String description, Money cost, int cal){
		super(description, cost, cal);
	}
	/**@returns description, cost and calories*/
	public String toString(){
		return "Cheese:" + super.toString();
	}

}



