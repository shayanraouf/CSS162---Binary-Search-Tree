import java.util.Scanner;
import java.util.Stack;

/*  PizzaManager Skeleton File
 *  CSS 161, Final Project
 * 
 * 	This class is a starting point for your final project and is incomplete.
 *  Start by reading the documentation(comments), and then the code.  Find the 
 *  empty stub methods you are to fill in using a Top-Down approach (see the
 *  assignment for more information on this and Stepwise Refinement)
 * 
 *  Author: Rob Nash
 *  Modified by: Shayan Raouf
 */

public class PizzaManager {
	private ArrayList<Pizza> pizzaList;


	/* 
	 * The console interface is defined in the start method 
	 * You can exit or extend the code below to accomplish all of 
	 * the outcomes defined in the homework document
	 */
	public void start() {
		char selection='q';

		

		pizzaList = new ArrayList<Pizza>();
		while(true) { 
			Scanner foo = new Scanner(System.in);
			displayAllPizzas(); // displays all the pizza's 
			displayInstructions(); // displays all the instructions 
			String read = foo.next(); // reads the user input as a string
			selection = read.charAt(0); // takes the first char element in save

			switch(selection) {
			case	'A':    
			case	'a':	System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
							addRandomPizza();
							break;
			case	'H':    
			case	'h':	System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
							addHundredPizza();	
							break;					
			case	'E':    
			case	'e':	System.out.println("Eating a fraction of a pizza. How much? (a/b)");
								
									eatSomePizza(foo); // call to eat pizza method
									break;//breaks or catches the exception and re-loops
										
			case	'P':    
			case	'p': 	System.out.println("QuickSorting pizzas by (P)rice");
							quickSortByPrice();
							break;	
			case	'S':    
			case	's': 	System.out.println("QuickSorting pizzas by (S)ize");
							quickSortBySize();
							break;		  
			case	'C':    
			case	'c':  	System.out.println("QuickSorting pizzas by (C)alories");
							quickSortByCalories();
							break;
			case	'B':
			case	'b':	System.out.println("(B)inary search over pizzas by calories(int).  QuickSorting first. What calorie count are you looking for?");
							int input = foo.nextInt();
							System.out.println(binarySearchByCalories(input));
							break;
			case    'R':
			case 	'r':	System.out.println("(R)everse order of Pizzas with a Stack" );
							reverseOrder();
							break;
			case    'Q':
			case 	'q':	System.out.println("(Q)uitting!" );
							System.out.println("\n\nProgram Completed"); // Notifies the user that the program has completed
							System.exit(0); // exits the programs
							break;
			default:	System.out.println("Unrecognized input - try again");
						continue;

			}
			
		}	
		
	}


	/**This method takes in Scanner key as input and properly calculates 
	 * the fraction amount and deducts and from the pizza. The first while
	 * loop checks for a proper "a/b" fraction input and catches the incorrect
	 * values and notifies the user to input a valid fraction. The second while
	 * loop does the same for the index given*/
	private void eatSomePizza(Scanner key) {		
		// variable Initialization 
		String fractionInput;
		String index;
		while(true){ // this handles the fraction 
			//first try/catch
			try{
				fractionInput = key.next(); //reads the input as a String
				String s = fractionInput.charAt(0) + "";
				if(s.equalsIgnoreCase("Q")){ // putting this here so they can quit at any time
					System.out.println("(Q)uitting!" );
					System.out.println("\n\nProgram Completed"); // Notifies the user that the program has completed
					System.exit(0); // exits the programs
				}
				Integer.parseInt(s); // will throw an exception if not a numerical value
				if(Integer.parseInt(s) == 1)break;
				if(!(fractionInput.contains("/")))throw new PizzaException();
				break;
			}
			catch(Exception e){
			System.out.println("Invalid fraction, try again");
			continue;
			}
		}
			
		while(true){
			//second try/catch
			try{
				System.out.println("Pick an index");
				index = key.next();
				if(index.equalsIgnoreCase("Q")){ // putting this here so they can quit at any time
					System.out.println("(Q)uitting!" );
					System.out.println("\n\nProgram Completed"); // Notifies the user that the program has completed
					System.exit(0); // exits the programs
				}
				Integer.parseInt(index); // will throw an exception if not a numerical value
				if(Integer.parseInt(index) < 0) throw new PizzaException("Negative index is not valid"); // out of bounds
				if(pizzaList.getElement(Integer.parseInt(index)) == null) throw new PizzaException("No pizza to be eaten");// no pizza to be eaten 
				if(Integer.parseInt(index) > pizzaList.size() - 1){throw new PizzaException("Not valid index"); // out of bounds
				
				}else{break;}
				
			}
			catch(Exception e){ // catch users mistake  
				System.out.println("Invalid index, try again\n");
				continue; // and continue 
			}
			
		}
			
		
		//read the first line and separate it from the "/" delimiter
	
		String[] fractionCollapse = fractionInput.split("/");
	
		//Covert the two integer values from a String to an int
		int numer = 0;
		int denom = 0;
		
		for(int i = 0; i < fractionCollapse.length; i++){ // iterate through
			String input = fractionCollapse[i]; // Retrieving data 
			Scanner retVal = new Scanner(input); // make a new Scanner and put input as it's args
			
			if(i == 0){
				numer = retVal.nextInt(); // update the retrieved numerator
			}
			else{
				denom = retVal.nextInt(); // update the retrieved denominator 
			}
			retVal.close(); //closes the Scanner
		}
		
		try{
		Fraction send = new Fraction(numer,denom); // sets the numerator and denominator 
		Pizza p = pizzaList.getElement(Integer.parseInt(index)); // gets the element of the pizzs
		p.setRemaining(send); // call to set remaining pizza
		}
		catch(PizzaException e){ // if exceptions have been thrown we catch over here and we remove it from the list
			System.out.println("Pizza removed from list");
			pizzaList.remove(Integer.parseInt(index)); // removes from the list
			
		}
		
	}
	
	/**This method removes the zero'th element of the pizza and pushes it 
	 * into a temp stack. Later we unwind the stack, popping the each element
	 * back into the list which gives it a reversed order */
	public void reverseOrder(){
		Stack<Pizza> temp = new Stack<Pizza>(); // stack initialization 
		while(!pizzaList.isEmpty()){ // while the pizzaList is not empty iterate through the list
			temp.push(pizzaList.remove(0)); // remove the first element from the list and push it in the stack
		}
		
		while(!temp.isEmpty()){ // while we still have element
			pizzaList.add(temp.pop()); // pop each element and add them back into the list
		}
	}
	/**This method adds 100 pizza's to the list**/
	public void addHundredPizza(){
		for(int i = 0; i < 100; i++){ // iterates to a 100
			addRandomPizza(); // adds a random pizza each time
		}
	}
	/**This method adds a random pizza to the list*/
	private void addRandomPizza() {
		Pizza p = new Pizza();
		pizzaList.add(p);
	}
	/**This method displays all the pizzas
	 * and prints the toString of the ArrayList*/
	private void displayAllPizzas() {
		System.out.println(pizzaList);
	}
	/**This method does the quick sort algorithm 
	 * by calling the sort method and sends in "cost"
	 * to quick sort by price**/
	public void quickSortByPrice() {  
		sort("cost");
	}

	/**This method does the quick sort algorithm 
	 * by calling the sort method and sends in "size"
	 * to quick sort by size**/
	private void quickSortBySize() {
		sort("size");
	}
	/**This method does the quick sort algorithm 
	 * by calling the sort method and sends in "cal"
	 * to quick sort by Calories**/
	private void quickSortByCalories() {
		sort("cal");
	}
	

/**This method is takes in a String which defines
 * how we're going to perform the quicksort and calls
 * the quicksort method*/
private void sort(String compare) {
    quicksort(pizzaList, 0, pizzaList.size()-1, compare);
}
/**This recursive method takes in an ArrayList of comparable pizza's as inputer
 * and two ints on zero and another at the size of the array -1 and a string compare
 * to determine what compare to partion call we're going to use, partionCal,size or price*/
private void quicksort(ArrayList<Pizza> a, int lowNum, int highNum, String compare) {
    if(lowNum >= highNum) return;
    int num;
    if(compare.equals("cost")){ // if "cost" call to partition by cost
    	num = partitionCost(a, lowNum, highNum);
    	 quicksort(a, lowNum, num-1,"cost");
         quicksort(a, num+1, highNum,"cost");
    }
    else if(compare.equals("cal")){ // if "cal" call to partition by calories
    	num = partitionCal(a, lowNum, highNum);
    	 quicksort(a, lowNum, num-1,"cal");
         quicksort(a, num+1, highNum,"cal");
    }
    else if(compare.equals("size")){ // if "size" call to partition by size
    	num = partitionSize(a, lowNum, highNum);
        quicksort(a, lowNum, num-1,"size");
        quicksort(a, num+1, highNum,"size");
    }

}

/**The quick sort algorithm splits the array into partitions on a pivot. 
 * Some of the elements in the current partition is chosen as the pivot 
 * then we swap the elements hence all that is on the left most side
 * is smaller then the right most side is greater. We have the best case
 * generally at O(n log n) and a worst case of O(n^2). This method applies
 * to partitioning it by calories*/
private int partitionCal(ArrayList<Pizza> a, int lowNum, int HighNum) {
    int i = lowNum + 1;
    int j = HighNum;

    while(i <= j) {
        if(a.getElement(i).compareToByCalories(a.getElement(lowNum)) <= 0){i++;}
        else if(a.getElement(j).compareToByCalories(a.getElement(lowNum)) > 0){j--;}
        else if(j < i){break;}
        else{a.swap(i, j);} // call to swap method in arraylist
    }
    a.swap(lowNum, j); // call to swap method in arraylist
    return j;
}
/**The quick sort algorithm splits the array into partitions on a pivot. 
 * Some of the elements in the current partition is chosen as the pivot 
 * then we swap the elements hence all that is on the left most side
 * is smaller then the right most side is greater. We have the best case
 * generally at O(n log n) and a worst case of O(n^2). This method applies
 * to partitioning it by size*/
private int partitionSize(ArrayList<Pizza> a, int lowNum, int highNum) {
    int i = lowNum + 1;
    int j = highNum;

    while(i <= j) {
        if(a.getElement(i).compareToBySize(a.getElement(lowNum)) <= 0){i++;}
        else if(a.getElement(j).compareToBySize(a.getElement(lowNum)) > 0){j--;}
        else if(j < i){break;}
        else{a.swap(i, j);} // call to swap method in arraylist
    }
    a.swap(lowNum, j); // call to swap method in arraylist
    return j;
}

/**The quick sort algorithm splits the array into partitions on a pivot. 
 * Some of the elements in the current partition is chosen as the pivot 
 * then we swap the elements hence all that is on the left most side
 * is smaller then the right most side is greater. We have the best case
 * generally at O(n log n) and a worst case of O(n^2). This method applies
 * to partitioning it by cost*/
private int partitionCost(ArrayList<Pizza> a, int lowNum, int highNum) {
    int i = lowNum + 1;
    int j = highNum;

    while(i <= j) {
        if(a.getElement(i).compareTo(a.getElement(lowNum)) <= 0){i++;}
        else if(a.getElement(j).compareTo(a.getElement(lowNum)) > 0){j--;}
        else if(j < i){break;}
        else{a.swap(i, j);} // call to swap method in arraylist
    }
    a.swap(lowNum, j); // call to swap method in arraylist
    return j;
}

	/**This method takes in an integer cals representing calories
	 * and preforms a binary Search by calories*/
	private int binarySearchByCalories(int cals) {
		int min = 0;
		int max = pizzaList.size() - 1; // - 1 from size to not go out of bounds

		while(min <= max){
			int mid = (min + max)/2; // Medium is the sum of minimum and maximum divided in half
			if(pizzaList.getElement(mid).getCalories() < cals){ //if cal < target cal update min
				min = mid + 1; // update by moving up one element
			}
			else if(pizzaList.getElement(mid).getCalories() > cals){// if cal > target update the max
				max = mid - 1;// up update by moving down one element
			}
			else{		
				return pizzaList.indexOf(pizzaList.getElement(mid)); // return found! 
			}
		}
		
		return -(min + 1); // not found
	}

	/*
	 * No need to edit functions below this line, unless extending the menu or
	 * changing the instructions
	 */
	private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nQuickSort pizzas by (P)rice\nQuickSort pizzas by (S)ize\nQuickSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(R)everse order of pizzas with a stack\n(Q)uit\n";
	private void displayInstructions() {
		System.out.println(instructions);	
	}
	/*
	 * Notice the one-line main function.
	 */
	public static void main(String[] args) {
		new PizzaManager().start();
	}

}
