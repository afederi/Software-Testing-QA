
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.io.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 * @author alexfederico
 *	Test:
 *		isBlank 				(Completed)
 *		startsWithIgnoreCase 	(Completed)
 *		endsWithIgnoreCase		(Completed)
 *		containIgnoreCase		(Completed)
 *		ArrayUtils				(Completed)	
 *		RandomStringUtils		(Completed)
 *		RandomUtils				(Completed)
 *		inputStream				(Completed)
 *		File					(Completed)
 *		
 *
 */


public class TestApache_Commons {
	
	
	private static final int Default_Timeout = 1000000;
	/**
	 * <pre>
	 * StringUtils.isBlank(null)
	 * StringUtils.isBlank("")
	 * StringUtils.isBlank(" ")
	 * StringUtils.isBlank("bob")
	 * StringUtils.isBlank(" bob ")
	 * </pre>
	 * 
	 * 
	 */
	String text;
	String text2="";
	File tmpOutput;
	@Before
	public void beforeTest() {
		
		//Setting up the text in input.txt for the FileUtils input test
		 text = "Reporting-MTA: dns; relay.mailchannels.net\n"
				+ "X-Postfix-Queue-ID: 958CF100A5A\n"
				+ "X-Postfix-Sender: rfc822; \n"
				+ "Arrival-Date: Fri, 20 Mar 2020 15:05:42 +0000 (UTC)\n"
				+ "\n"
				+ "Final-Recipient: rfc822; \n"
				+ "Original-Recipient: rfc822;\n"
				+ "Action: failed\n"
				+ "Status: 5.1.1\n"
				+ "Remote-MTA: dns; gmail-smtp-in.l.google.com\n"
				+ "Diagnostic-Code: smtp; 550-5.1.1 The email account that you tried to reach does\n"
				+ "    not exist. Please try 550-5.1.1 double-checking the recipient's email\n"
				+ "    address for typos or 550-5.1.1 unnecessary spaces. Learn more at 550 5.1.1\n"
				+ "    https://support.google.com/mail/?p=NoSuchUser k9si2703832pgt.469 - gsmtp";
	
	
		 for(int i=0;i<9;i++) {
			 text2+=RandomStringUtils.randomAlphanumeric(30)+"\n";
		 }
		 text2+=RandomStringUtils.randomAlphanumeric(30);
		 //Setting up a temporary file to use in the FileUtils output tests
		 try {
				tmpOutput = File.createTempFile("tempOutput", ".txt");
			}catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	
	@Test (timeout = Default_Timeout)
	public void testBlank() {
		boolean a=StringUtils.isBlank(null);
		
		Assert.assertEquals("This is null test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testBlank2() {
		boolean a=StringUtils.isBlank("");
		
		Assert.assertEquals("This is null test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testBlank3() {
		boolean a = StringUtils.isBlank("bob");
		
		Assert.assertEquals(" This is a null test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testBlank4() {
		boolean a = StringUtils.isBlank(" bob ");
		
		Assert.assertEquals(" This is a null test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testBlank5() {
		boolean a = StringUtils.isBlank(" ");
		
		Assert.assertEquals(" This is a null test", true, a);
	}
	@Test (timeout = Default_Timeout)
	public void testBlank6() {
		boolean a = StringUtils.isBlank("             ");
		
		Assert.assertEquals(" This is a null test", true, a);
	}
	
	/**
	 * startsWithIgnoreCase test cases
	 */
	
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase() {
		boolean a = StringUtils.startsWithIgnoreCase("This is a test", "T");
		
		Assert.assertEquals(" This is a starts with and Ignore Case test", true, a);	
	}
	
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase2() {
		boolean a = StringUtils.startsWithIgnoreCase(" What is a test anyways", " ");
		
		Assert.assertEquals(" This is a starts with and Ignore Case test", true, a);		
	}
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase3() {
		
		//This should be expected false because the the inputed text start with a blank
		boolean a = StringUtils.startsWithIgnoreCase(" Whose test is it anyways", "THi");
		
		Assert.assertEquals(" This is a starts with and Ignore Case test", false, a);	
	}
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase4() {
		boolean a = StringUtils.startsWithIgnoreCase("Classes are somewhere", "cL");
		
		Assert.assertEquals(" This is a starts with and Ignore Case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase5() {
		boolean a = StringUtils.startsWithIgnoreCase("null values should not count", null);
		
		Assert.assertEquals(" This is a starts with and Ignore Case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase5_1() {
		//I assume that null by itself is not a string but combined with a string turns it into one
		boolean a = StringUtils.startsWithIgnoreCase(null+" null values should not count", null);

		Assert.assertEquals(" This is a starts with and Ignore Case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase5_2() {
		//I assume that null by itself is not a string but combined with a string turns it into one
		boolean a = StringUtils.startsWithIgnoreCase(null+" A null values should not count", null+" A");

		Assert.assertEquals(" This is a starts with and Ignore Case test", true, a);
	}
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase5_3() {
		//I assume that null by itself is not a string but combined with a string turns it into one
		boolean a = StringUtils.startsWithIgnoreCase(null+" A null values should not count", null+" Zebra");

		Assert.assertEquals(" This is a starts with and Ignore Case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase6() {
		//char 84 is uppercase T
		char b = 84;
		String c = ""+b;
	
		boolean a = StringUtils.startsWithIgnoreCase("This tests the char value of Uppercase T", c);
		
		Assert.assertEquals(" This is a starts with and Ignore Case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase7() {
		//char 84 is lowercase T: t
		char b = 116;
		String c = ""+b;
		
		boolean a = StringUtils.startsWithIgnoreCase("This tests the char value of Lowercase t", c);
		
		Assert.assertEquals(" This is a starts with and Ignore Case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase8() {
		boolean a = StringUtils.startsWithIgnoreCase(null, null);
		
		Assert.assertEquals(" This is a starts with and Ignore Case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testStartsWithIgnoreCase9() {
		boolean a = StringUtils.startsWithIgnoreCase(null, " " );
		
		Assert.assertEquals(" This is a starts with and Ignore Case test", false, a);
	}
	
	/**
	 * These are all the ends with + ignore case tests
	 */
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase() {
		boolean a = StringUtils.endsWithIgnoreCase(null, null);
		
		Assert.assertEquals(" This is an ends with and ignore case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase2() {
		boolean a = StringUtils.endsWithIgnoreCase("This is an ends with test"+null, null);
		
		//This is false because the ""+null is a string and not a null
		Assert.assertEquals(" This is an ends with and ignore case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase3() {
		boolean a = StringUtils.endsWithIgnoreCase("This test may work"+null, null+"");
		
		Assert.assertEquals(" This is an ends with and ignore case test",  true, a);
		
	}
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase4() {
		boolean a = StringUtils.endsWithIgnoreCase("", null+"");
		
		Assert.assertEquals("This is an ends with and ignore case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase5() {
		boolean a = StringUtils.endsWithIgnoreCase(null, null+"");
		
		Assert.assertEquals("This is an ends with and ignore case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase6() {
		boolean a = StringUtils.endsWithIgnoreCase("This will be the ends test", "TEST");
		
		Assert.assertEquals("This is an ends with and ignore case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase7() {
		boolean a = StringUtils.endsWithIgnoreCase("This will be the WHAT?", "? ");

		Assert.assertEquals("This is an ends with and ignore case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase8() {
		boolean a = StringUtils.endsWithIgnoreCase("This will end now", "now");
		
		Assert.assertEquals("This is an ends with and ignore case test", true,a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase9() {
		
		char b = 116;
		String c = ""+b;
		
		
		boolean a = StringUtils.endsWithIgnoreCase("No you can't", c);
		
		Assert.assertEquals("This is an ends with and ignore case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testEndsWithIgnoreCase10() {
		//This is capitol T
		char b = 84;
		String c = ""+b;
		
		
		boolean a = StringUtils.endsWithIgnoreCase("No you can't", c);
		
		Assert.assertEquals("This is an ends with and ignore case test", true, a);
	}
	
	
	
	/**
	 * These tests test out containsIgnoreCase() method
	 */
	
	
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase() {
		
//I though this would be true since both are null, but it is considered false
		boolean a = StringUtils.containsIgnoreCase(null,null);
		
		
		Assert.assertEquals("This is a contains with an ignore case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase2() {
		boolean a = StringUtils.containsIgnoreCase(" "+null, null);
		
		Assert.assertEquals("This is a contains with an ignore case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase3() {
		boolean a = StringUtils.containsIgnoreCase(null, null+" ");
		
		Assert.assertEquals("This is a contains with an ignore case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase3_2() {
		
//This on is also interesting in that this is considered true but when both all null individually, it doesn't work
		boolean a = StringUtils.containsIgnoreCase(null+" ", null+" ");
		
		Assert.assertEquals("This is a contains with an ignore case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase3_3() {
		boolean a = StringUtils.containsIgnoreCase(null+" ", " "+null);
		
		Assert.assertEquals("This is a contains with an ignore case test", false, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase4() {
		boolean a = StringUtils.containsIgnoreCase("This is a contains test with ignore cases", " ");
		
		Assert.assertEquals("This is a contains with an ignore case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase5() {
		boolean a = StringUtils.containsIgnoreCase("This is a contains test with ignore cases", "C");
		
		Assert.assertEquals("This is a contains with an ignore case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase6() {
		
//A value of ""(blank) is considered contained within the string value
		boolean a = StringUtils.containsIgnoreCase("This is a contains test with ignore cases", "");
		
		Assert.assertEquals("This is a contains with an ignore case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase7() {
		boolean a = StringUtils.containsIgnoreCase(" ", "");
		
		Assert.assertEquals("This is a contains with an ignore case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase8() {
		boolean a = StringUtils.containsIgnoreCase("", "");
		
		Assert.assertEquals("This is a contains with an ignore case test", true, a);
	}
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase8_2() {
		boolean a = StringUtils.containsIgnoreCase("", " ");
		
		Assert.assertEquals("This is a contains with an ignore case test", false, a);
	}
	
	
	@Test (timeout = Default_Timeout)
	public void testContainsIgnoreCase9() {
		boolean a = StringUtils.containsIgnoreCase("Lets test this out", "l");
		
		Assert.assertEquals("This is a contains with an ignore case test", true, a);
	}
	
	
	/**
	 * Here we are testing the arrayutils method
	 */
	
	@Test (timeout = Default_Timeout)
	public void testArrayUtils() {
		
		String arr1 = "{1,2,3}";
		String[] arrA = {"1", "2", "3"};
		String arr2 = ArrayUtils.toString(arrA);
		
		Assert.assertEquals("This is an array test", arr1, arr2);
		
	}
	
	@Test (timeout = Default_Timeout)
	public void testArrayUtils2() {
		String s1 = "{1,2,<null>}";
		String[] arr = {"1","2",null};
		String s2 = ArrayUtils.toString(arr);
		
		Assert.assertEquals("This is an array test", s1, s2);
		
	}
	
	@Test (timeout = Default_Timeout)
	public void testArrayUtils3() {
		String s1 = "{1,2,3}";
		int[] arr = {1,2,3};
		String s2 = ArrayUtils.toString(arr);
		
		Assert.assertEquals("This is an array toString test", s1, s2);

	}
	
	@Test (timeout = Default_Timeout)
	public void testArrayUtils4() {

		String s1 = "{1.0,2.33,3.0}";
		double[] arr = {1, 2.33, 3.0};
		String s2 = ArrayUtils.toString(arr);

		Assert.assertEquals("This is an array toString test",s1, s2);	
	}
	
	@Test (timeout = Default_Timeout)
	public void testArrayUtils5() {
		String s1 = "{a,b,c}";
		char x = 97;
		char y = 98;
		char z = 99;
		char[] arr = {x,y,z};
		String s2 = ArrayUtils.toString(arr);
		
		Assert.assertEquals("This is an array toString test", s1, s2);
		
	}
	
	@Test (timeout = Default_Timeout)
	public void testArrayUtils6() {

		String s1 = "{a,b,7}";
		char x = 'a';
		char y = 'b';
		char z = '7';
		char[] arr = {x,y,z};
		String s2 = ArrayUtils.toString(arr);
		
		Assert.assertEquals("This is an array toString test", s1,s2);
	}
	@Test (timeout = Default_Timeout)
	public void testArrayUtils7() {
		
		String s1 = "{1,3,4.5,c,<null>}";
		Object[] arr = {1,"3",4.5, 'c', null};
		String s2 = ArrayUtils.toString(arr);
		
		Assert.assertEquals("This is an array toString test", s1, s2);
		
	}
	
	/**
	 * Here, we are testing the RandomStringUtils() methods
	 */
	
	@Test (timeout = Default_Timeout)
	public void testRandomStringUtils() {
	
		String randomStr = RandomStringUtils.randomAlphanumeric(1);	
		
		Assert.assertNotNull(randomStr);
	}
	
	@Test (timeout = Default_Timeout, expected=IllegalArgumentException.class)
	public void testRandomStringUtils2() {
	
		String randomStr = RandomStringUtils.randomAlphanumeric(-1);	
		
		Assert.assertNotNull(randomStr);
	}
	
	
	//This test require an expected NullPointerException because of the method throws the error in the method
	@Test (timeout = Default_Timeout, expected=NullPointerException.class)
	public void testValidateNotNull() {
	
		String a = null;
		String b = Validate.notNull(a);
	
		Assert.assertNull(b);
	}
	
	@Test (timeout = Default_Timeout)
	public void testValidateNotNull2() {
	
		String a = "This is a test";
		String b = Validate.notNull(a);
	
		Assert.assertNotNull(b);
	}
	
	//Here we are testing out the IO function of the org.apache.commons.io library
	@Test (timeout = Default_Timeout)
	public void testInputStream() {
		InputStream in = null;
		try {
			in = new URL("https://commons.apache.org").openStream();
			//System.out.println(IOUtils.toString(in, CharEncoding.UTF_8) );
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly();
		}
	}
	
	
	@Test (timeout = Default_Timeout)
	public void testInputStream2() throws IOException {
		InputStream in = null;
		try {
			in = new URL("https://commons.apache.org").openStream();
			//System.out.println("LET'S GOOOO!!!");
			
			
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader buf = new BufferedReader(inR);
			String line;
			while((line = buf.readLine())!=null) {
				//System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			in.close();
		}
	}
	
	/**
	 * I think that this was a bit too complex for a test and may re-edit this 
	 * to be a single function test and have all this work on a outside class
	 * 
	 */
	
	//Testing the FileUtils library to get the file and read it
	@Test(timeout = Default_Timeout)
	public void testFileUtils() {
		
		//For this case, the input.txt file is assumed to be in the Project folder
		// For a specific location the parameters are: FileUtils.getFile(<Input PATH>, <Input File>)
		File file = FileUtils.getFile("input.txt");
		try {
			//Catch all lines from the file and split each line into an array
			List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());
			
			
			//Splitting the actual hard coded text in this file and splitting it by the \n
			String[] elements = text.split("\n");
			List<String> lines2 = Arrays.asList(elements);
			
			//The text between the text and the text in the file should be the same
			//this also includes the line breaks
			Assert.assertEquals("This is testing file I/O(Input", lines, lines2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Testing the FileUtils library to Write to file
	@Test(timeout = Default_Timeout)
	public void testFileUtils2() {
		String t="This is the outputStream for this file";
		String t2=null;
		try {
			FileUtils.writeStringToFile(tmpOutput, t, Charset.defaultCharset());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			t2 = FileUtils.readFileToString(tmpOutput,Charset.defaultCharset());
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals("This is a test to test the output method for FileUtils", t, t2);	
	}
	
	@Test(timeout = Default_Timeout)
	public void testFileUtils3() {
		try {
			File file = new File("Output.txt");
			for(int i=0;i<10;i++) {
				System.out.println(i);
				FileUtils.writeStringToFile(file, text2, Charset.defaultCharset());
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			String data = FileUtils.readFileToString(new File("Output.txt"), Charset.defaultCharset());
			
			Assert.assertEquals("This is a test to test the FileUils write to file method", text2, data);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
/**
 * These are test that can cause errors at the moment. May polish this test class to added expected errors on these test cases
 */
	
//This does not run well due to heap space
	/**
	//This gets really slow when you have a character count over a billion
	@Test (timeout = Default_Timeout)
	public void testRandomStringUtils2() {
		
		//This gets really slow when you have a character count over a billion
		String randomStr = RandomStringUtils.randomAlphanumeric(1000000000);	
		
		Assert.assertNotNull(randomStr);
	}
	**/
	
	
	/**
	
//This does not run because the array size if over the VM limit
	@Test (timeout = Default_Timeout)
	public void testRandomStringUtils3() {
	
		//This seems like the highest number that the randomAlphanumeric method can handle
	
		String randomStr = RandomStringUtils.randomAlphanumeric(2147483647);	
		
		Assert.assertNotNull(randomStr);
	}
	**/
	

	
}
