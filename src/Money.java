import java.io.Serializable;

/**Description: This class Money class contains dollars and cents as 
 * private fields and returns those vales, sets those values and adds those
 * Money, Date, and Bill class to implement the Comparable interface. 
 * The supplied driver performs a simple test on this. Remember that 
 * compareTo takes an Object parameter and you should check to make sure
 * that the object is actually a Money object. Money, Date, and Bill classes
 * to implement the Cloneable interface. Note that Money and Date can simply
 * copy their private instance variables, since they store only primitive and
 * immutable types. However, you will need to override the clone method, to 
 * make it public, since it is protected in the Object class. The Bill class
 * will need to do more, since it incorporates the Money and Date classes, which
 * are mutable. Note that it can (and should) use the clone methods of those 
 * classes. Be sure to remove any use of the copy constructor for Money, Date, 
 * and Bill in the rest of the code (the definition can exist, but don’t use it
 * in other classes; use the clone method instead).
 * Project: Money.java
 * @author shayanraouf
 */
public class Money implements Comparable<Money>, Cloneable, Serializable{
	
	//Serializable
	private static final long serialVersionUID = -6703912681157038127L;
	//Declaration of instance variables set to private
	private int dol;
	private int cent;

	//Default constructor sets both to zero
	public Money(){
		dol = 0;
		cent = 0;		
	}

	/**Constructor that calls the method which checks
	 * for validation and sets dollars and cents*/
	public Money(int dol, int cent){
		setMoney(dol,cent);

	}

	/**This Constructor takes in an int
	 * Parameter and calls the other constructor 
	 * for efficiency and code reduction*/
	public Money(int value){
		this(value, 0);

	}

	/**Copy Constructor that takes in an object
	 * as a parameter of type Money and
	 * Initializes the values*/  
	public Money(Money other){
		this(other.dol, other.cent);

	}

	/**This method takes in two parameters of
	 * type int calls isValid and once passed validation
	 * initializes dollars and cents
	 * **setMoney is broken, double check***/
	public void setMoney(int dol, int cent){
		if(dol < 0 || cent < 0) throw new PizzaException();
		this.dol = dol;
		if(cent > 100){
			dol += cent/100;
			cent = cent%100;
		}
		else{
			this.cent = cent;
		}
	}



	/**This method returns the value of the
	 * the total money as a double*/
	public double getMoney(){

		double cent = this.cent;
		double getMoney = (cent * 0.01) + this.dol;
		getMoney = (double)Math.round(getMoney * 100) / 100;
		return getMoney;
	}

	/**This method calls the add function and adds
	 * the values passed in*/
	public void add(int dol){
		add(dol, 0);

	} 

	/**Takes two parameters of type double
	 * and adds the dollars and cents*/
	public void add(int dol, int cent){

		if(dol > -1 && cent > -1 && cent < 100){
			this.dol += dol;
			this.cent += cent;

		}
		else{
			System.err.println("The Money values entered were invalid");
			System.exit(-1);			
		}

	}

	/**this method takes in an object parameter
	 * of the class money and uses the add function
	 * to add the dollars and cents to our private fields*/
	public void add(Money other){
		add(other.dol, other.cent);		
	}



	/**Accepts an object parameter from the 
	 * class Object and casts it to the Money
	 * class and compares and checks if it's 
	 * equal to the dollars and cents and if equals
	 * @returns true*/
	public boolean equals(Object other){
		if(other == null && !(other instanceof Money)) throw new PizzaException();
		boolean isEqual = false;
		Money moneyObj = (Money)other;

		if(this.dol == moneyObj.dol &&
				this.cent == moneyObj.cent){
			isEqual = true;

		}

		return isEqual;
	}

	/**Returns a String with the money
	 * value by calling the getMoney() method*/
	public String toString(){
		return "$" + getMoney();

	}
	
	/**This method implements the Comparable method
	 * by comparting "that".money to "this".money*/
	public int compareTo(Money money){
		if(money == null) throw new NullPointerException(); //null checker, throws exception
		if(!(money instanceof Money)) throw new IllegalArgumentException(); //instanceof Checker
		
		if(money.getMoney() < getMoney()){ //if "that".money < this.money
			return 1; 
		}
		else if(money.getMoney() > getMoney()){// if otherwise > 
			return -1;
		}
		else{
			return 0; // they're equal
		}
	}
	
	/**This method @returns a new Money 
	 * we implemented the Cloneable interface
	 * so we are fulfilling the contract*/
	public Money clone(){
		Money retVal = new Money(dol, cent);
		return retVal;
	}

}
