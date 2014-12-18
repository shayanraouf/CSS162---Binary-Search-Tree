/**Description: This set of classes will be used to decorate Pizza Objects.  
 * They’ll manage their cost and calorie count per serving, as well as define
 * some custom characteristics (read member variables) like Colors for the 
 * Vegetable subclass.  Before starting on the code, be sure to check out 
 * the inheritance hierarchy at the beginning of this assignment
 * @author shayanraouf
 */
public class Ingredient implements Comparable<Ingredient>{
	
	//variable declaration
	protected final Money cost;
	protected final String description;
	protected final int kcal; //calories
	 
	/**This constructor takes three args and sets 
	 * description of the ingredient, cost and calories*/
	public Ingredient(String description, Money cost, int Kcal){
		this.description = description;
		this.cost = cost;
		this.kcal = Kcal;
	}
	
	/**@returns description, cost and calories*/
	public String toString(){
		return description + " Cost:" + cost + " Calories:" + kcal;
	}
	/**This takes in an Ingredient as an argument 
	 * and calls the Compare to by cost*/
	public int compareTo(Ingredient ingredient){
		return cost.compareTo(ingredient.cost);
	}

}
