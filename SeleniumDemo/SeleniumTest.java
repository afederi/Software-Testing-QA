
import java.util.concurrent.TimeUnit;

/**Libraries used:
 * 		selenium-chrome-driver-4.1.3.jar
 * 		selenium-server-4.1.3.jar
 * 		JUnit 5
 * 
 */

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * TEST IDEAS
 * 		Odd inputs (Cybersecurity)
 */


/**
 * 
 * @author alexfederico
 *  A demo of Using Selenium
 *
 */
public class SeleniumTest {
		
	//To use WebDriver, you need to import org.openqa.selenium.*
	private static WebDriver driver;
	
	//Setting up global variables so that it is easier to populate input boxes
	private static String firstName;
	private static String lastName;
	private static String password;
	private static String number;
	private static String email;
	private static String comments;
	
	
	
	@BeforeClass
	public static void setUpChrome() {
	// Create a new WebDriver instance (Use Chrome)
	// download ChromeDriver from: // and put the path here...
	
		
	
	//You've got to download chromedriver set the stringe value to the absolute location of your crhomedriver	
	System.setProperty("webdriver.chrome.driver", "/Users/alexfederico/Downloads/chromedriver");
	
	//To use ChromeDriver, you need to import org.openqa.selenium.chrome.*
	driver = new ChromeDriver();
	
	
	
	//Setting up values for global variables
	firstName = "Steve";
	lastName = "Green";
	number = "555-555-5555";
	email = "sGreen@email.com";
	comments ="This is not a hack. This is just a test D:";
	password = "password1234!";
	
	}
	
	
	
	//Testing a google search of ggc
	@Test
	public void googleSearchExample() throws Exception {
			
	// Use webdriver to visit Google. Here the webdriver will launch google chrome and go to google.com
	driver.get("http://www.google.com");
	
	// Find the text input element by its name
	// On the google.com page, the driver will find the element used to obtain input on the search bar.
	// In this case, q is the name of the element which is used for input on the search bar
	WebElement element = driver.findElement(By.name("q"));
	
	// Enter something to search for
	// This clears the search bar to make sure there is no input on the search bar
	element.clear();
	
	// Here, the element adds GGC to the search bar
	element.sendKeys("GGC");
	// Now submit the form. WebDriver will find the form for us from the element
	// This begins
	element.submit();
	
	
	//It seems that the submit command does not need an implicit wait condition
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts();
	
	//rcnt is the 
	WebElement nextPageElement = driver.findElement(By.id("rcnt"));
	System.out.println("Page title is: " + driver.getTitle());
	Assert.assertTrue("Expected GGC in title", driver.getTitle().contains("GGC"));
	}
	
	
//A test seen in class
	@Test
	public void testClassExampleTwo() {
		driver.get("http://redx.altervista.org/Activities/3-22.html");
		
		WebElement sID = driver.findElement(By.name("studentId"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement rePassword = driver.findElement(By.name("password2"));
		WebElement fname = driver.findElement(By.name("fname"));
		WebElement lname = driver.findElement(By.name("lname"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zip = driver.findElement(By.name("zip"));
		Select level = new Select(driver.findElement(By.id("level")));
		WebElement ownCom = driver.findElement(By.name("ownComputer"));
		WebElement hours = driver.findElement(By.id("t2"));
		WebElement favBrowser = driver.findElement(By.name("chrome"));
		Select major = new Select(driver.findElement((By.name("major"))));
		WebElement register = driver.findElement(By.xpath("/html/body/form/input[1]"));
		
		sID.sendKeys("1002");
		password.sendKeys("pass");
		rePassword.sendKeys("pass");
		fname.sendKeys("bob");
		lname.sendKeys("builder");
		phone.sendKeys("111-111-1111");
		email.sendKeys("bobBuild@gmail.com");
		city.sendKeys("Atlanta");
		street.sendKeys("Build St");
		state.sendKeys("Georgia");
		zip.sendKeys("3000");
		level.selectByIndex(2);
		ownCom.click();
		hours.click();
		favBrowser.click();
		major.selectByIndex(2);
		register.click();
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		
		WebElement Confirmation = driver.findElement(By.xpath("/html/body/h1"));
		System.out.println(Confirmation.getText());
		
		
		//The assertion must be at the actual page you're test in order for it to run properly
		Assert.assertTrue("Should be a confirmation page", Confirmation.getText().contains("Thank you for your registration"));

		
		WebElement link = driver.findElement(By.linkText("here"));
		link.click();	
	}
	
	//Simple demo of a automated test for a registration page
	@Test 
	public void registrationPage() {
		
		//First, we use a Google webdriver to launch a the url below
		driver.get("http://tand.altervista.org/Activities/3-12.html");
		
		/**
		 * We're going to populate all the input boxes though java code
		 */
		
		
//First Name:
		//We find the element name of the first input box: First name
		WebElement element = driver.findElement(By.name("fname"));
		
		//We clear the first name input box element to remove any previous values
		element.clear();
		
		//Input the value using sendKeys into the input box of First name
		element.sendKeys(firstName);
		
		
		
//Last Name:
		//We find the element name of the last name input box
		element=driver.findElement(By.name("lname"));
		
		//We clear the last name input box element to remove any previous values
		element.clear();
		
		//Input the value using sendKeys into the input box of Last name
		element.sendKeys(lastName);
		
		
		
//Phone number:
		//We find the element name of the Phone number input box
		element=driver.findElement(By.name("phone"));
		
		//We clear the phone number input box element to remove any precious value
		element.clear();
		
		//Input the value using sendKeys into the input box of Phone number
		element.sendKeys(number);
		
		
		
//E-mail:
		//We find the element name of the email input box
		element=driver.findElement(By.name("email"));
		
		//We clear the email input box element to remove any previous values
		element.clear();
		
		//Input the value using sendKeys into the input box of email
		element.sendKeys(email);
		
		
		
//Comment Box:
		//We find the element name of the comment input box
		//This one I switched from By.name to By.id just to make it different
		element=driver.findElement(By.id("comments"));
		
		//We clear the comment input box element to remove any precious values
		element.clear();
		
		//Input the value using sendKeys into the input box of comments
		element.sendKeys(comments);
		
		
//Radio decisions
		//We find the element by finding the xpath of a specific radio button
		//Since name is the same for all radio buttons and there is no ID, we use xpath
		element=driver.findElement(By.xpath("/html/body/form/input[2]"));
		
		//Click on the specific radio box
		element.click();
		
		element.submit();
		
		driver.manage().timeouts();
		
		element = driver.findElement(By.xpath("/html/body"));
		
		System.out.println("Test: "+ driver.getCurrentUrl());
		
		Assert.assertTrue(element.getText().contains("Thank you for providing comments."));
		
	}
	

	
	
	
	
//A test to make sure the password is not in the URL
		@Test 
		public void registrationPageSecurity() {
			
			//First, we use a Google webdriver to launch a the url below
			driver.get("http://tand.altervista.org/Activities/3-12.html");
			
			/**
			 * We're going to populate all the input boxes though java code
			 */
			
			
	//First Name:
			//We find the element name of the first input box: First name
			WebElement element = driver.findElement(By.name("fname"));
			
			//We clear the first name input box element to remove any previous values
			element.clear();
			
			//Input the value using sendKeys into the input box of First name
			element.sendKeys(firstName);
			
			
			
	//Last Name:
			//We find the element name of the last name input box
			element=driver.findElement(By.name("lname"));
			
			//We clear the last name input box element to remove any previous values
			element.clear();
			
			//Input the value using sendKeys into the input box of Last name
			element.sendKeys(lastName);
			
			
			
	//Phone number:
			//We find the element name of the Phone number input box
			element=driver.findElement(By.name("phone"));
			
			//We clear the phone number input box element to remove any precious value
			element.clear();
			
			//Input the value using sendKeys into the input box of Phone number
			element.sendKeys(number);
			
			
			
	//E-mail:
			//We find the element name of the email input box
			element=driver.findElement(By.name("email"));
			
			//We clear the email input box element to remove any previous values
			element.clear();
			
			//Input the value using sendKeys into the input box of email
			element.sendKeys(email);
			
			
			
	//Comment Box:
			//We find the element name of the comment input box
			//This one I switched from By.name to By.id just to make it different
			element=driver.findElement(By.id("comments"));
			
			//We clear the comment input box element to remove any precious values
			element.clear();
			
			//Input the value using sendKeys into the input box of comments
			element.sendKeys(comments);
			
			
	//Radio decisions
			//We find the element by finding the xpath of a specific radio button
			//Since name is the same for all radio buttons and there is no ID, we use xpath
			element=driver.findElement(By.xpath("/html/body/form/input[2]"));
			
			//Click on the specific radio box
			element.click();
			
			element.submit();
			
			driver.manage().timeouts();
			
						
			//
			Assert.assertFalse(driver.getCurrentUrl().toLowerCase().contains("Password") && driver.getCurrentUrl().contains(password));
			
		}
		
//Making sure no data inputed is also in the url
		@Test 
		public void registrationPageSecurity2() {
			
			//First, we use a Google webdriver to launch a the url below
			driver.get("http://tand.altervista.org/Activities/3-12.html");
			
			/**
			 * We're going to populate all the input boxes though java code
			 */
			
			
	//First Name:
			//We find the element name of the first input box: First name
			WebElement element = driver.findElement(By.name("fname"));
			
			//We clear the first name input box element to remove any previous values
			element.clear();
			
			//Input the value using sendKeys into the input box of First name
			element.sendKeys(firstName);
			
			
			
	//Last Name:
			//We find the element name of the last name input box
			element=driver.findElement(By.name("lname"));
			
			//We clear the last name input box element to remove any previous values
			element.clear();
			
			//Input the value using sendKeys into the input box of Last name
			element.sendKeys(lastName);
			
			
			
	//Phone number:
			//We find the element name of the Phone number input box
			element=driver.findElement(By.name("phone"));
			
			//We clear the phone number input box element to remove any precious value
			element.clear();
			
			//Input the value using sendKeys into the input box of Phone number
			element.sendKeys(number);
			
			
			
	//E-mail:
			//We find the element name of the email input box
			element=driver.findElement(By.name("email"));
			
			//We clear the email input box element to remove any previous values
			element.clear();
			
			//Input the value using sendKeys into the input box of email
			element.sendKeys(email);
			
			
			
	//Comment Box:
			//We find the element name of the comment input box
			//This one I switched from By.name to By.id just to make it different
			element=driver.findElement(By.id("comments"));
			
			//We clear the comment input box element to remove any precious values
			element.clear();
			
			//Input the value using sendKeys into the input box of comments
			element.sendKeys(comments);
			
			
	//Radio decisions
			//We find the element by finding the xpath of a specific radio button
			//Since name is the same for all radio buttons and there is no ID, we use xpath
			element=driver.findElement(By.xpath("/html/body/form/input[2]"));
			
			//Click on the specific radio box
			element.click();
			
			element.submit();
			
			driver.manage().timeouts();
			
			element = driver.findElement(By.xpath("/html/body"));
			
			//If any of the info inputed is found in the url, then the test fails.
			Assert.assertFalse("Info inputed on input box found in url", driver.getCurrentUrl().toLowerCase().contains(firstName) || driver.getCurrentUrl().toLowerCase().contains(lastName) || driver.getCurrentUrl().toLowerCase().contains(number) || driver.getCurrentUrl().toLowerCase().contains(email) || driver.getCurrentUrl().toLowerCase().contains(comments)  );			
		}
		
//What happens when a radio button is not selected
		@Test 
		public void registrationPageNoRadioSelection() {
			
			//First, we use a Google webdriver to launch a the url below
			driver.get("http://tand.altervista.org/Activities/3-12.html");
			
			/**
			 * We're going to populate all the input boxes though java code
			 */
			
			
	//First Name:
			//We find the element name of the first input box: First name
			WebElement element = driver.findElement(By.name("fname"));
			
			//We clear the first name input box element to remove any previous values
			element.clear();
			
			//Input the value using sendKeys into the input box of First name
			element.sendKeys(firstName);
			
			
			
	//Last Name:
			//We find the element name of the last name input box
			element=driver.findElement(By.name("lname"));
			
			//We clear the last name input box element to remove any previous values
			element.clear();
			
			//Input the value using sendKeys into the input box of Last name
			element.sendKeys(lastName);
			
			
			
	//Phone number:
			//We find the element name of the Phone number input box
			element=driver.findElement(By.name("phone"));
			
			//We clear the phone number input box element to remove any precious value
			element.clear();
			
			//Input the value using sendKeys into the input box of Phone number
			element.sendKeys(number);
			
			
			
	//E-mail:
			//We find the element name of the email input box
			element=driver.findElement(By.name("email"));
			
			//We clear the email input box element to remove any previous values
			element.clear();
			
			//Input the value using sendKeys into the input box of email
			element.sendKeys(email);
			
			
	//Comment Box:
			//We find the element name of the comment input box
			//This one I switched from By.name to By.id just to make it different
			element=driver.findElement(By.id("comments"));
			
			//We clear the comment input box element to remove any precious values
			element.clear();
			
			//Input the value using sendKeys into the input box of comments
			element.sendKeys(comments+"HelloWorld");
			
			
			
			element.submit();
			
			driver.manage().timeouts();
			
			element = driver.findElement(By.xpath("/html/body"));
			
		}
		
	
	
	
	
	@AfterClass
	public static void endChrome() {
		//Closing the google window so that it does not need to manually be closed. 
		//Prevents excessive windows from opening when doing multiple tests
	
		//driver.close();
	}
	
	
	
}
