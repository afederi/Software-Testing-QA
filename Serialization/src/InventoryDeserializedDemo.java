import java.io.*;
import org.apache.commons.io.*;
import org.apache.commons.lang3.SerializationUtils;

/**
 * 
 * @author alexfederico
 * This is the Deserialization demo for inventory 
 * that uses the org.apache.commons.lang3 library for deserialization
 * 
 */

public class InventoryDeserializedDemo {
	public static void main (String[]args) {
		
		//Declaring the varible I as an Inventory object
		Inventory I;
		
		
		//Use the file class to locate a file in the system and assign it to the file variable
		File file = FileUtils.getFile("/tmp/", "inventory.obj");
		
		//Initializing the byte[] variable to null
		byte[] dataToDeserialize = null;
		
		try {
			//Reads the content inside of the file and turn it to an Array of bytes
			dataToDeserialize = FileUtils.readFileToByteArray(file);	
		} catch (IOException e) {
			//This catch is to handle any input/output errors
			e.printStackTrace();
		}
		
		
		//Calls the deserialize method in the SerializationUtils class
		//to turn the byte[] into an object of type inventory and assigning it to I
		I = SerializationUtils.deserialize(dataToDeserialize);

		
		//This try and catch is set up a way to output prints onto a txt file
		try {
			
			
			FileOutputStream fileIn = new FileOutputStream("/tmp/inventoryOutput.txt");
			PrintStream out = new PrintStream(fileIn);
			
			//Checks to see if Inventory is null or not
			if(I != null) {
				
				//Printing out every vehicle in Inventory and outputting onto the file inventoryOutput.txt
				for (Vehicle v : I.getInventoryList()) {
					out.print(v.toString()+"\n");
				}
					
			}else {
				System.out.println("Did not deserialized");
			}
			
			out.close();
			
			
		}catch (IOException i) {
			System.out.println("I/O Error");
			i.printStackTrace();
		}
		
		
		
		//Do a for each loop to print out all the vehicles in the Inventory list
		for (Vehicle v : I.getInventoryList()) {
			System.out.println(v.toString()+"\n");
		}
		
	}

}
