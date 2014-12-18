import java.util.Iterator;

/**Description: We are going to be implementing out 
 * own ArrayList Class with the following functions
 * void add(Object, int index)
 * Object remove(int index)
 * int size()
 * String toString()
 * boolean isEmpty()
 * int indexOf(Object) //-1 if not found
 * boolean equals(Object);  //compare sizes and elements in the list
 * The purpose of this assignment is to understand the concepts of ArrayLists
 * and being able to use them with knowing all their functionality 
 * @author shayanraouf
 */

@SuppressWarnings("hiding")
public class ArrayList<Comparable> implements Iterable<Comparable>{
	//Private instance variables declared 
	private Comparable[] object;
	private int numElement;

	/**This Constructor takes in parameter 
	 * of a type int capacity which will set 
	 * the initial capacity of the Object array*/
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity){
		//check before casting

		object = (Comparable[]) new Object[capacity];
		numElement = 0;
	}

	/**Calls the above constructor and passes
	 * in a value of 100 to set the initial capacity to 100*/
	public ArrayList(){
		this(100);				
	}

	/**This will resize the Array by doubling
	 * the length of the Object array*/
	private void resize(){
		//Declaring temp array of objects with double the size
		@SuppressWarnings("unchecked")
		Comparable[] resized = (Comparable[]) new Object[object.length * 2];
		for(int i = 0; i < numElement; i++){
			resized[i] = object[i];
		}
		object = resized;
	}

	public void add(Comparable value){
		add(value, numElement);
	}

	/**This method adds to the Object array passed in
	 * at an index that is also passed in*/
	public void add(Comparable value, int index){
		if(value == null) throw new NullPointerException(); //throw exception for null or out of bounce
		if((index < 0) || (index > numElement)) throw new IndexOutOfBoundsException("Accessing an out of bounce element");	
		if(numElement == object.length){
			resize(); // Enlarges the array if full		
		}

		arrayShiftRight(index); //calls methods to shift the arrays to the right
		object[index] = value; //insert the Comparable value
		numElement++;
	}

	/**Shifts the elements in the object array to the right*/
	private void arrayShiftRight(int index){
		for(int i = numElement; i > index; i--){
			object[i] = object[i - 1];		
		}	
	}

	/**Shifts the elements in the object array to the left*/
	private void arrayShiftLeft(int index){		
		for(int i = index; i < numElement - 1; i++){
			object[i] = object[i + 1];			
		}
	}
	
	public Comparable getElement(int index){
		return object[index];
	}
	
	public void swap(int i, int j){
		Comparable temp = object[i];
		object[i] = object[j];
		object[j] = temp;
	}

	/**This method removes the object in the array
	 * at the index in which that has been passed to us
	 * and @returns the object that has been removed*/
	public Comparable remove(int index){
		//checks for out of bounce
		if(index < 0 || index >= numElement) throw new PizzaException("Accessing an out of bounce element");
		Comparable retVal = object[index]; // save return value	
		arrayShiftLeft(index); //shifts to the left/deletes the value	
		numElement--;	

		return retVal;	
	}


	/**@returns the size of the ArrayList*/
	public int size(){
		return numElement;	
	}

	/**This toString method @returns [] if the number of elements are empty or
	 * @returns the object values in the array nicely displayed in a string like
	 * [object, object, object] etc.*/
	public String toString(){
		String retVal = "";
		if(isEmpty()){
			return "";

		}
		else{
			
			for(int i = 0; i < numElement; i++){
				retVal += "[" + object[i] + "]\n";		

			}
			
		}

		return retVal;
	}

	/**This method checks to see if there any objects in the object array*/
	public boolean isEmpty(){
		boolean retVal = false;
		//checks if numElement is equal to 0
		if(numElement == 0){
			//if yes that means there are no comparable objects in the array
			retVal = true;			
		}
		return retVal;
	}

	/**@returns the int value of the position of the object being passed in
	 * @returns -1 if not found*/
	public int indexOf(Comparable other){
		int retVal = -1;
		if(other == null) throw new NullPointerException();	
		//loops through and checks for object passed in
		for(int i = 0; i < numElement; i++){
			//checks if the classes are equal before comparing
			if(object[i].getClass().equals(other.getClass())){

				//checks if the objects are equal
				if(object[i].equals(other)){
					retVal = i;
				}
			}	

		}
		return retVal; 		
	}

	/**@returns true of the object being passed
	 * in is present in the ArrayList*/
	@Override
	public boolean equals(Object obj){
		if(obj == null) throw new NullPointerException();
		if(!(obj instanceof ArrayList<?> )) throw new IllegalArgumentException("Invalid Paramater Type");

		//Casting to an ArrayList
		ArrayList<?> castedArrayList = (ArrayList<?>)obj;
		if(size() == castedArrayList.size()){
			for(int i = 0; i < numElement; i++){		
				//comparing 'this' object to 'that' object
				if(!object[i].equals(castedArrayList.object[i])){ 
					return false;
				}			
			}
		}

		return true;
	}
	
	/**This is the implementation of the Iterator method which takes
	 * in a generic of a Comparable in addition
	 * this implements hasNext(), next() and remove()
	 * this is the same implementation of what the Scanner has
	 * while(hasNext()) etc.*/
	public Iterator<Comparable> iterator(){
		Iterator<Comparable> retVal = new Iterator<Comparable>(){

			private int index = 0;

			public boolean hasNext() {

				//checking if the index is not out of bounce
				return index < numElement && object[index] != null;
			}


			public Comparable next() {
				return object[index++];

			}

			public void remove() {
				object[index] = null;
			}

		};
		return retVal;
	}

}


