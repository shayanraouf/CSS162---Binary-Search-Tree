import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;


/**Description: Much of the work for managing Pizzas goes into this class.  
 * A Pizza has a list of ingredients, a shape, a cost, a calorie total, and
 * a few other details.  Pizzas can be eaten, and once a pizza is completely
 * gone (i.e., the Fraction is 0) they should be removed from our 
 * PizzaManager’s list by way of a thrown exception.  Let’s declare an empty
 * class called Pizza that implements comparable; consider using Stepwise 
 * Refinement here, on any of the following steps, to flesh out more detail 
 * and make implementation more straightforward.(Rob Nash)
 * Project: Pizza.java
 * @author shayanraouf
 */
public class Pizza implements PizzaComparable{
	//Decloration of instance variables
	private Shape myShape;
	private Fraction fraction;
	private Money cost;
	private int totalCalories;
	private ArrayList<Ingredient> ingredients;
	private DecimalFormat f = new DecimalFormat("#.00");
	/**Constructor that sets the shape of pizza*/
	public Pizza(Shape shape, ArrayList<Ingredient> ingredients){
		this.myShape = shape.clone();
		this.fraction = new Fraction(1,1); // creates a fraction 1/1
		for(int i = 0; i < ingredients.size(); i++){
			this.ingredients.add(ingredients.remove(0), i);
		}
	}

	/**This constructor is Similar to the on above exception this 
	 * is a random constructor which adds a random pizza*/
	public Pizza(){
		ingredients = new ArrayList<Ingredient>();
		cost = new Money();		
		fraction = new Fraction(1,1); // creates a fraction 1/1
		//addIngredients(new Goat());
		if(Math.random() > 0.5){ // Creates a new Cheese 
			//ingredients.add(new Goat(), 0); // Goat if > 0.5
			addIngredients(new Goat());

		}
		else{

			addIngredients(new Mozzarella()); // adds mozzarella
		}


		if(Math.random() > 0.5){  // Creates a Base 

			addIngredients(new Marinara ()); // adds marinara
		}
		else{
			addIngredients(new Alfredo ()); //adds alfredo 
		}



		if(Math.random() > 0.5){ // creates the vegetable
			addIngredients(new Pepper()); //adds peppers
		}
		else{
			addIngredients(new Olive()); // adds olives 
		}



		if(Math.random() > 0.5){ // sets either to Circle or Square

			Circle cir = new Circle((int)Math.random() * 100, (int)Math.random() * 10, Math.random() * 100);
			myShape = cir.clone(); 
		}
		else{
			Square squ = new Square((int)Math.random() * 100, (int)Math.random() * 100, Math.random() * 100);
			myShape = squ.clone();
		}



	}

	/**This method takes in an Ingredient as an argument and
	 * sets the ingredients while updating the fields*/
	public void addIngredients(Ingredient a){
		if(a == null)throw new NullPointerException("here");
		ingredients.add(a,0);
		setCalories(a.kcal);
		setCost(a.cost);
	}

	/**Uses the add method in Money and sets and adds*/
	public void setCost(Money c){
		cost.add(c);
	}

	/**@return the cost, uses clone to avoid privacy leaks*/
	public Money getCost(){
		return cost.clone();
	}

	/**@returns the total Calories in the Pizza*/
	public int getCalories(){
		return totalCalories;
	}

	/**Sets the calories by at argument taken in*/
	public void setCalories(int k){
		totalCalories += k;
	}

	/**This method sets the remaining pizza that is left
	 * it takes in a Fraction f as input and calculates based
	 * off of the Fraction the user inputs of how much they want to eat from the pizza*/
	public void setRemaining(Fraction f){
		double rate = cost.getMoney() / fraction.getDoubleVal(); // sets the rat of the pizza
		try{
			if(this.fraction.sub(f).getDoubleVal() < 0) throw new PizzaException();
		this.fraction = this.fraction.sub(f); // subtracts and sets the fraction
		}
		catch(Exception e){
			System.out.println("not enough pizza left to eat");
			return;
		}
		
		if(this.fraction.getDoubleVal() == 0) throw new PizzaException(); // throw exception if it == 0
		double doubleVal = fraction.getDoubleVal() * rate; // Multiply by the rate
		String cost = doubleVal + ""; // Concatenate to a string
		String[] collapse = cost.split("\\."); // split it into a string 

		int dol = Integer.parseInt(collapse[0]); // get the dollar value and set to dol
		int cent = Integer.parseInt(collapse[1].substring(0,2)); // get the cent value and set to cent

		this.cost = new Money(dol, cent); // set the new money value 
		totalCalories = totalCalories - (int)(f.getDoubleVal() * totalCalories); // update the total calories 

	}

	/**@returns a new Fraction of the remainng*/
	public Fraction getRemaining(){
		return new Fraction(fraction);
	}

	/**This sets the shape by calling the clone method*/
	public void setShape(Shape s){ 
		myShape = (Shape)s.clone();
	}
	/**This method @returns the shape, uses the clone method */
	public Shape getShape(){ 
		return (Shape)myShape.clone();
	}

	/**This toString method @returns a String of the price,calories,fraction,area,and shapes*/
	public String toString(){
		return "Pizza has a price:" + cost.toString() + " and calories:" + totalCalories +
				" Fraction remaining:" + fraction.toString() +
				" and area left: " + f.format(myShape.getArea() * fraction.getDoubleVal()) + " and " + myShape.toString();
	}


	/**This method takes in another pizza object
	 * and compares the pizza's together. @returns -1
	 * if less than, 1 greater than and 0 if they're equal to
	 * Price*/
	public int compareTo(Object o){
		if(o == null) throw new NullPointerException();
		if(!(o instanceof Pizza)) throw new PizzaException();
		Pizza obj = (Pizza)o;
		return cost.compareTo(obj.cost);
	}

	/**This method takes in pizza object and compares
	 * the pizza by the size. @returns -1 if less than,
	 * 1 greater than and 0 if they're equal to in size*/
	public int compareToBySize(Object o){
		if(o == null) throw new NullPointerException();
		if(!(o instanceof Pizza)) throw new PizzaException();
		Pizza obj = (Pizza)o;
		if(this.myShape.getArea() < obj.myShape.getArea()){
			return -1;
		}
		else if(this.myShape.getArea() > obj.myShape.getArea()){
			return 1;
		}
		else{
			return 0;
		}
	}
	/**This method compares the pizza by the calories.
	 * @returns -1 if less than, 1 greater than and 0
	 * if they're equal in calories*/
	public int compareToByCalories(Object o){
		if(o == null) throw new NullPointerException();
		if(!(o instanceof Pizza)) throw new PizzaException();
		Pizza obj = (Pizza)o;
		if(this.totalCalories < obj.totalCalories){
			return -1;
		}
		else if(this.totalCalories > obj.totalCalories){
			return 1;
		}
		else{
			return 0;
		}
	}

}
