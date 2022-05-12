import java.io.*;

/**
 * 
 * @author alexfederico
 * This is a class that handles the Vehicle class
 *
 */


public class Vehicle implements Serializable {
	
	
	//Variables that are required in the class
	private String makeModel;
	private int year;
	private double retailPrice;
	private boolean is4wD;
	
	//The constructor
	public Vehicle(String mM, int year, double rP, boolean wd) {
		makeModel = mM;
		this.year = year;
		retailPrice = rP;
		is4wD = wd;
	}
	
	//toString method that returns the makeModel, year, and retailprice
	public String toString() {
		return makeModel+" "+year+"\n+"+retailPrice;
		
	}
	
}
