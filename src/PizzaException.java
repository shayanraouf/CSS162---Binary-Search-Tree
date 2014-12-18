
/**Description: LinkedListException with extends RuntimeException 
 * therefore inheriting all the functionalities of 
 * RunTimeException. We will be using this for our
 * List class calling it and throwing new exceptions
 * when needed. 
 * Project: PizzaException.java
 * @author shayanraouf 
 */
public class PizzaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 790713104846315278L;

	/**Constructor that accepts an argument
	 * of type String and passes it in to 
	 * parent class which prints the error message*/
	public PizzaException(String note){
		super(note);
		
	}
	
	/**Constructor that calls the parent class
	 * with no args, default Constructor*/
	public PizzaException(){
		super();	
	}

}