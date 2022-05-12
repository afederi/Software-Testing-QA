import java.io.*;


/**
 * 
 * @author alexfederico
 * Here we are testing out a basic serialization test.
 *
 */

public class DeserializedDemo {
	public static void main(String[]args) {
		
		//Initializing an Employee instance e and setting it to null
		Employee e = null;
		
		try {
			
			//Initializing the variable that will point to a specific file
			FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
			
			// Initialize a input method that takes the fileIn variable and reads the content inside
			ObjectInputStream in = new ObjectInputStream(fileIn);
		
			
			//takes the in variable and reads the content inside
			//Content inside is deserialized and Casting it into an Employee type 
			e = (Employee) in.readObject();
		
			
			//Required code to close the file input stream and object input stream
			in.close();
			fileIn.close();
			
			
		// Method that catches errors with the try statement
		}catch (Exception i){
			System.out.println("error involving the file");
		}
		
		
		//This line of code is a temporary variable that will change the System.out back to the console
		//It is used so that you can change the output to the console instead of the custom output
		PrintStream stdOut = System.out;
		
		
		// Here, we are setting up a way to output the employee info onto a txt file called employeeOutput
		try {
			
			FileOutputStream file = new FileOutputStream("/tmp/employeeOutput.txt");
			PrintStream out = new PrintStream(file);
			
			
			//Checks to see if the Employee is object or not
			if(e !=null) {
					
					//Common way to output into the file
					out.print(e.toString());
					
					//To write system.out.print() outputs, you use System.setOut and put out as your parameter for print stream
					System.setOut(out);
					System.out.println();
					e.mailCheck();
					
					//The System.setOut(stdOut) is used to convert the output back onto the console
					System.setOut(stdOut);
					System.out.println("Complete output\n");
				} else {
					System.out.println("Did not deserialized");
				}
			
			//Print stream needs to be closed at the end
			out.close();
		
		//This is an error handler for I/O errors
		}catch (IOException i) {
			System.out.println("I/O Error");
			i.printStackTrace();
		}
		
		
		
		//If the file is null, then the process of obtaining the contents of the file did not work
		//If the file is not null, then the system prints out the content of the saved employee instance
		if(e !=null) {
			System.out.println(e.toString());
		} else {
			System.out.println("Did not deserialized");
		}
		
	}
}
