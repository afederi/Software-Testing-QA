import java.io.*;

/**
 * 
 * @author alexfederico
 * This is a class to demonstrate serialization 
 * When you serialize the employee object and write it to a file, this is what you get in the file:
 * ??sEmployee^t4g?<InumberLaddresstLjava/lang/String;Lnameq~xpetPhokka Kuan, Ambehta Peert	Reyan Ali
 *
 */


public class SerializedDemo {
	public static void main (String[]args) {
		
		//Setting up e as an instance of Employee
		Employee e = new Employee();
		
		//Populating the information for employee instance e
		e.name = "Reyan Ali";
		e.address = "Phokka Kuan, Ambehta Peer";
		e.SSN = 111223333;
		e.number = 101;
		
		
		try {
			//You can serialize an object using FileOutputStream and ObjectOutputStream
			FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			//writing the variable e into the file employee.ser
			out.writeObject(e);
			
			//Required code that must be called to close out the file and output function
			out.close();
			fileOut.close();
			
			System.out.println("Serialized data is saved in /tmp/employee.ser");
		}catch (IOException i) {
			//This catch is to handle any input/output errors
			i.printStackTrace();
		}
	}

}
