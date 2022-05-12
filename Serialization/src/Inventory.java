import java.io.*;
import java.util.*;

/**
 * 
 * @author alexfederico
 *	This class holds an inventory variable for a list of vehicles
 */

public class Inventory implements Serializable{
	
	
	//This UID is used as a kind of version control so that when a program calls this class,
	// it is obtaining the right class
	private static final long serialVersionUID = -3363705253067912162L;

	//This is the global variable that holds a list of vehicles
	// List is an interface
	private List<Vehicle> inventoryList;
	
	
	//Constructor that initalized the list object as an ArrayList
	public Inventory() {
		inventoryList = new ArrayList<Vehicle>();
	}
	
	
	//Takes the argument v of type vehicle and stores it into the inventory list
	public void add(Vehicle v) {
		inventoryList.add(v);
	}
	
	//Takes the argument v of type vehicle and finds the object and remove from the list
	public void remove(Vehicle v) {
		inventoryList.remove(v);
	}
	
	
	//returns the List of vehicles
	public List<Vehicle> getInventoryList(){
		return inventoryList;
	}
	
	//Prints out all the vehicles in the list
	public void list() {
		for(Vehicle e : inventoryList) {
			System.out.println(e.toString());
		}
		
	}

}
