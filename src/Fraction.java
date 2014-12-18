
/**Description: The intent of this homework assignment is to
 * understand the concept of having many different classes and 
 * containing methods and using them in your main function by 
 * creating instances of them (objects)
 * 
 * The project description is as follows stated by Robb Nash:
 * "Your project is to read in a series of fractions from a 
 * text file, which will have each line formatted as 
 * follows:v“A/B”.  A sample text file is listed below, and
 * the purpose of your program is to read in one line at a 
 * time and build a Fraction object from A and B.  For each
 * unique Fraction seen, your program will create a FractionCounter
 * object used to track the number of occurrences of that 
 * specific fraction.  When all the input is consumed, your 
 * program will print out its ObjectList of unique FractionCounters,
 * which should report the fraction and its count – see output below.
 * You can assume no blank lines or misleading characters; see the 
 * text file link above for the some of the input I’ll use when testing
 * your submission. Your program must reduce fractions, as demonstrated 
 * in the output below."
 * Project: Fraction.java
 * @author shayanraouf
 */
public class Fraction {
	private final int numerator;
	private final int denominator;

	//Constructor that initializes the instance variables 
	public Fraction(int n ,int d){
		if(d == 0) throw new IllegalArgumentException("Denominator cannot be 0");
		int[] reduc = reduction(n,d);
		numerator = reduc[0]; //numerator
		denominator = reduc[1];//denominator

	}

	//default constructor
	public Fraction(){
		numerator = 0;	
		//can't divide by 0
		denominator = 1;	
	}

	public Fraction(Fraction f){
		numerator = f.numerator;
		denominator = f.denominator;
	}

	public double getDoubleVal(){
		return (double)numerator/(double)denominator;
	}

	/**This is the reduction algorithm that is used to 
	 * reduce the fraction by elude @returns an array of size
	 * 2 with the numerator in the first element and denominator
	 * in the second element */
	public int[] reduction(int n, int d){
		int[] retVal = new int[2];
		int gcd; // greatest common denominator 

		//dealing with only positive integers
		int nNum = Math.max(n,d);
		int dNum = Math.min(n,d);
		while(dNum != 0){ //while numerator is not equal 0
			int r = nNum % dNum;
			nNum = dNum;
			dNum = r;
		}

		//update the numerator  
		gcd = nNum;
		
		int redN = n / gcd;
		int redD = d / gcd;
		retVal[0] = redN; //updating the reduced numerator
		retVal[1] = redD; //updating the denominator numerator
		return retVal;

	}
	
	public Fraction multiply(Fraction f){
		int thiS = (numerator * f.getNumerator());
		int that = (denominator * f.getDenominator());
		return new Fraction(thiS, that);
	}
	
	public Fraction sub(Fraction f){
		int numer = (numerator * f.getDenominator()) - (denominator * f.getNumerator());
		int denom = denominator * f.getDenominator();
		return new Fraction(numer, denom);
	}

	/**compares “this” (the numerator) to the “other”
	 * numerator being passed in by being passed an
	 * Object and we later cast it to a fraction object
	 * and @returns is equals*/
	public boolean equals(Object other){
		boolean equals = false;
		Fraction fractionObj = (Fraction)other;
		if(numerator ==  fractionObj.numerator &&
				denominator ==  fractionObj.denominator){
			equals = true;		
		}
		return equals;
	}

	/**@returns the numerator*/ 
	public int getNumerator(){
		return numerator;

	}



	/**@returns the denominator*/
	public int getDenominator(){
		return denominator;

	}


	/**@returns the fraction*/
	public String toString(){
		if (denominator == 1) return numerator+""; 
		return numerator + "/" + denominator;

	}

}
