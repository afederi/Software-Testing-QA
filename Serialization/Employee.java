
/**
 * 
 * @author alexfederico
 * This is a class called employee that is used to store data of employee information.
 * When a method calls employee to create an instance of employee, the user must input:
 * 	name
 * 	address
 * 	SSN
 * 	number
 *
 */

public class Employee implements java.io.Serializable {
	
	
	//This UID is used as a kind of version control so that when a program calls this class,
	// it is obtaining the right class
	private static final long serialVersionUID = -4433705253067912162L;

	
	public String name;
	public String address;
	public transient int SSN;
	public int number;
	
	
	//This prints out the address for the employee instance
	public void mailCheck() {
		System.out.println("Mailing a check to "+ name + " "+address);
	}
	
}
