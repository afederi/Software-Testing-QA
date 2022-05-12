import java.io.File;
import java.io.IOException;

import org.apache.commons.io.*;
import org.apache.commons.lang3.SerializationUtils;

/**
 * 
 * @author alexfederico
 * This is a serialization demo that uses the apache.commons.lang3 library as a method of serialization
 *
 */

public class InventorySerializedDemo {
	public static void main (String[]args) {
		
		//Creating an instance of Inventory and assigning it to I
		Inventory I = new Inventory();
		
		//Creating Vehicle instances to populate the array in inventory
		Vehicle v1 = new Vehicle("Ford F150", 2015, 35000, false);
		Vehicle v2 = new Vehicle ("Ford F250", 2015, 75000, false);
		Vehicle v3 = new Vehicle ("Ford F350", 2015, 15000, false);
		
		
		//Adding the vehicle instances into the arraylist in inventory
		I.add(v1);
		I.add(v2);
		I.add(v3);
		
		
		//Setting up the file variable to create a file and store it into a given location
		File file = FileUtils.getFile("/tmp/", "inventory.obj");
		
		//use the serialize method from SerializationUtils class to turn the Inventory variable I into an array of bytes
		byte[] data = SerializationUtils.serialize(I);
		
		
		
		
		try {
			//writes the content of data into the file inventory.obj
			FileUtils.writeByteArrayToFile(file, data);
			
		}catch (IOException i) {
			//This catch is to handle any input/output errors
			i.printStackTrace();
		}
		
		System.out.println("inventory.obj has been serialized");
	}

}
