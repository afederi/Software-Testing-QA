import org.junit.Assert;
import org.junit.Test;


/**
 * 
 * @author alexfederico
 * 
 * 
 * 
 * ASUMPTIONS:
 * 	overtime pay will still be the same as hourly pay, so if there is overtime the pay will still be 20.5
 * 	Pay will always have a maximum of 5000.00. If the number of hours give a pay that is more than 5000, then it will drop to 5000
 *  
 *
 */

public class LawyerTest {
	
	//This test is done to check the Constructor is working
	@Test
	public void testNullObject() {
		Lawyer a = null;
		
		Assert.assertNull(null, a);
	}
	
	@Test
	public void testContructorEmpty() {
		Lawyer a = new Lawyer("");
		
		String lawyerName = a.getName();
		
		Assert.assertEquals("The ' ' is not handled", "" , lawyerName);
	}
	
	@Test
	public void testConstructorNull() {
		Lawyer a = new Lawyer(null);
		
		String lawyerName = a.getName();
		
		Assert.assertNull(lawyerName);
	}
	
	@Test
	public void testConstructor() {
		Lawyer a = new Lawyer("Bob");
		
		String LawyerName = a.getName();
		
		Assert.assertEquals("Bob",LawyerName);
	}
	
	
	@Test
	public void testVacationDays() {
		Lawyer bob = new Lawyer("Bob");
		
		int vacayDays = bob.getVacationDays();
		
		Assert.assertEquals("Wrong number of vacay days", 1, vacayDays);
	}
	
	//Here we are testing doLegalStuff() I have no idea what I should study. What would be the side effects when I run the doLegalStuff method? 
	// I think that since name is the only variable that can change, I evoked the getName method to see if the variable changes
	@Test
	public void testdoLegalStuff() {
		Lawyer bob = new Lawyer("c");
	
		String test = bob.getName();
		bob.doLegalStuff();
		String test2 = bob.getName();
		
		
		Assert.assertEquals(test,test2);
		
	}
	
	/**
	 * Here, we are testing a variety of hours and overtime combinations to see
	 * if the monthly wage method is working properly
	 * 
	 * The calculateMonthlyWage method arguments are: (hours, overtime)
	 * 
	 */
    
	//Here we are calculating no hours or overtime at all
	@Test
	public void calculateMonthlyWage01() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,0);
		
		
		//Argument is (String message, double expected, double actual, double delta)
		//The double delta is how much the actual can be off from the expected. In this case, the value has to be exactly the same as expected
		Assert.assertEquals("Max monthly wage must be 5000", 0, julyWage, 0);
		
	}
	
	//Here we are calculating with no hours but some overtime that is less than the minimum hours
	//This value will be negative, but the output should only by no less than $0
	@Test
	public void calculateMonthlyWage02() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,10);
		
		Assert.assertEquals("Max monthly wage must be 5000", 0.00, julyWage, 0);
		
	}
	
	// No hours but overtime is one hour less than the minimum
	@Test
	public void calculateMonthlyWage03() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,159);
		
		Assert.assertEquals("Max monthly wage must be 5000", 2259.5, julyWage, 0);
		
	}
	
	
	//Here we are calculating with no hours but with overtime that is exactly the minimum
	@Test
	public void calculateMonthlyWage04() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,160);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3280.00, julyWage, 0);
	}
	
	// Here we are testing with no hours but overtime is 1 hour above the minimum
	@Test
	public void calculateMonthlyWage05() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,161);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3300.50, julyWage, 0);
	}
	
	
	//Here we are calculating with no hours but overtime is over the minimum and less than the maximum
	@Test
	public void calculateMonthlyWage06() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,200);
		
		Assert.assertEquals("Max monthly wage must be 5000", 4100.00, julyWage, 0);
	}
	
	
	//Here we are calculating with no hours but overtime is over the minimum and one hour less than the maximum
	@Test
	public void calculateMonthlyWage07() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,249);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000, julyWage, 0);
	}
	
	//Here we are calculating with no hours but overtime is exactly the maximum hours
	@Test
	public void calculateMonthlyWage08() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,250);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating with no hours but overtime is above the maximum hours
	@Test
	public void calculateMonthlyWage09() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,251);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating with no hours but overtime is at one month worth of hours
	@Test
	public void calculateMonthlyWage10() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(0,730);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating with some hours but no overtime
	@Test
	public void calculateMonthlyWage11() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(13,0);
		
		Assert.assertEquals("Max monthly wage must be 5000", 0.00, julyWage, 0);
	}

	//Here we are calculating with some hours that is 1 hour less than the minimum and no overtime
	@Test
	public void calculateMonthlyWage12() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(159,0);
		
		Assert.assertEquals("Max monthly wage must be 5000", 2259.50, julyWage, 0);
	}
	
	//Here we are calculating with hours that are exactly at minimum and no overtime
	@Test
	public void calculateMonthlyWage13() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(160,0);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3280.00, julyWage, 0);
	}
	
	//Here we are calculating with hours that is 1 hour more than the minimum and no overtime
	@Test
	public void calculateMonthlyWage14() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(161, 0);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3300.5, julyWage, 0);
	}
	
	//Here we are calculating with hours that is in between the minimum and maximum hours and no overtime
	@Test
	public void calculateMonthlyWage15() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(200, 0);
		
		Assert.assertEquals("Max monthly wage must be 5000", 4100, julyWage, 0);
	}
	
	//Here we are calculating with hours that is 1 hour less than the maximum and no overtime
	@Test
	public void calculateMonthlyWage16() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(249,0);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000, julyWage, 0);
	}
	
	//Here we are calculating with hours that are exactly the maximum and no overtime
	@Test
	public void calculateMonthlyWage17() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(250,0);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating with hours that are 1 hour over the maximum and no overtime
	@Test
	public void calculateMonthlyWage18() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(251, 0);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating with hours that are 1 months worth of hours and no overtime
	@Test
	public void calculateMonthlyWage19() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(730,0);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating with hours and overtime where the overall hours are less than the minimum
	//This should hit the penalty which should be negative, but should only be at $0.0
	@Test
	public void calculateMonthlyWage20() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(10,20);
		
		Assert.assertEquals("Max monthly wage must be 5000", 0.00, julyWage, 0);
	}
	
	//Here we are calculating with hours and overtime being overall 1 hour less than the minimum with hours being more than overtime
	@Test
	public void calculateMonthlyWage21() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(100,59);
		
		Assert.assertEquals("Max monthly wage must be 5000", 2259.50, julyWage, 0);
	}
	
	//Here we are calculating with hours and overtime being overall 1 hours less than the minimum with overtime being more than hours
	@Test
	public void calculateMonthlyWage22() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(59,100);
		
		Assert.assertEquals("Max monthly wage must be 5000", 2259.50, julyWage, 0);
	}
	
	//Here we are calculating with hours and overtime being overall 1 hour less than the minimum with both hours and overtime being roughly the same
	//Hours and overtime are integers so for this 79.5 will drop to 79
	@Test
	public void calculateMonthlyWage23() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(79,79);
		
		Assert.assertEquals("Max monthly wage must be 5000", 2239.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is exactly the minimum hours and hours is more than overtime
	@Test
	public void calculateMonthlyWage24() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(120,40);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3280.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is exactly the minimum hours and overtime is more than hours
	@Test
	public void calculateMonthlyWage25() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(40,120);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3280.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is exactly the minimum hours and both hours and overtime are equal
	@Test
	public void calculateMonthlyWage26() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(80,80);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3280.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is within the minimum and maximum hours. Hours is more than overtime
	@Test
	public void calculateMonthlyWage27() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(140, 50);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3895.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is within the minimum and maximum hours. Overtime is more than hours.
	@Test
	public void calculateMonthlyWage28() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(50,140);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3895.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is within the minimum and maximum hours. Overtime and hours are the same value
	@Test
	public void calculateMonthlyWage29() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(100,100);
		
		Assert.assertEquals("Max monthly wage must be 5000", 4100.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is within 1 hour less than the maximum hours. Hours is more than overtime
	@Test
	public void calculateMonthlyWage30() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(201, 48);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is within 1 hour less than the maximum hours. Overtime is more than hours
	@Test
	public void calculateMonthlyWage31() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(48,201);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is within 1 hours less than the maximum hours. OVertime and hours are equal
	// Since the arguments for calcaulateMonthlyWage is in integers, the .5 is dropped from the hours
	@Test
	public void calculateMonthlyWage32() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(124,124);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total are exactly the maximum hours. hours is more than overtime
	@Test
	public void calculateMonthlyWage33() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(190,60);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total are exactly the maximum hours. Overtime is more than hours
	@Test
	public void calculateMonthlyWage34() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(60,190);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	//Here we are calculating where hours and overtime total is exactly the maximum hours. Overtime and hours are equal
	@Test
	public void calculateMonthlyWage35() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(125,125);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is more than the maximum. Hours is more than overtime
	@Test
	public void calculateMonthlyWage36() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(300,250);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is more than the maximum. Overtime is more than hours
	@Test
	public void calculateMonthlyWage37() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(250,300);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000.00, julyWage, 0);
	}
	
	//Here we are calculating where hours and overtime total is more than the maximum. Overtime and hours are the same
	@Test
	public void calculateMonthlyWage38() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(400,400);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000, julyWage, 0);
	}
	
	//Here we are calculating wages where hours is negative
	@Test
	public void calculateMonthlyWage39() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(-140,20);
		
		Assert.assertEquals("Max montly wage must be 5000",3280.00, julyWage,0);
	}
	//Here we are calculating wages where overtime is negative
	@Test
	public void calculateMonthlyWage40() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(20,-160);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3690.00, julyWage, 0);
	}
	//Here we are calculating wages where both overtime and hours are negative
	@Test
	public void calculateMonthlyWage41() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(-20,-160);
		
		Assert.assertEquals("Max monthly wage must be 5000", 3690.00, julyWage, 0);
	}
	//Here we are testing the maximum integer for hours 
	@Test
	public void calculateMonthlyWage42() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(2147483641,40);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000, julyWage, 0);
	}
	
	//Here we are testing input where both overtime and hours are the maximum integer
	@Test
	public void calculateMonthlyWage43() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(2147483647,2147483647);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000, julyWage, 0);
	}
	
	//Here we are testing input where overtime is the maximum integer
	@Test
	public void calculateMonthlyWage44() {
		Lawyer bob = new Lawyer("Bob");
		
		double julyWage = bob.calculateMonthlyWage(7,2147483647);
		
		Assert.assertEquals("Max monthly wage must be 5000", 5000, julyWage, 0);
	}
	
	
	//Here we are testing the maximum negative integer for hours 
		@Test
		public void calculateMonthlyWage45() {
			Lawyer bob = new Lawyer("Bob");
			
			double julyWage = bob.calculateMonthlyWage(-2147483648,40);
			
			Assert.assertEquals("Max monthly wage must be 5000", 5000, julyWage, 0);
		}
		
		//Here we are testing input where both overtime and hours are the maximum negative integer
		@Test
		public void calculateMonthlyWage46() {
			Lawyer bob = new Lawyer("Bob");
			
			double julyWage = bob.calculateMonthlyWage(-2147483648,-2147483648);
			
			Assert.assertEquals("Max monthly wage must be 5000", 5000, julyWage, 0);
		}
		
		
		
		//Here we are testing input where overtime is the maximum integer
		@Test
		public void calculateMonthlyWage47() {
			Lawyer bob = new Lawyer("Bob");
			
			double julyWage = bob.calculateMonthlyWage(7,-2147483648);
			
			Assert.assertEquals("Max monthly wage must be 5000", 5000, julyWage, 0);
		}
	
}
