
/**
 * 
 * @author alexfederico
 *
 */

public class Lawyer extends Employee {
	
		private final double HOURLY_WAGE = 20.5;
		private final int MAXIMUM_HOURS_ALLOWED = 250;
		private final int MINIMUM_HOURS_REQUIRED = 160;
		private final int PENALTY = 1000;
		private final int MAX_MONTHLY_WAGE = 5000;
		
		public Lawyer (String name) {
			super(name);
		}
		
		public int getVacationDays() {
			
			return 1;
		}
		
		
		/**
		 * 
		 * @param hours
		 * @param overtime
		 * @return
		 * 
		 * This method is designed to fit with the JUnit tests
		 * 
		 */
		public double calculateMonthlyWage(int hours, int overtime) {
			
			/**
			 * This if statement is used to check for negative numbers for hours
			 */
			if(hours<0) {
				//Implemented to handle the maximum negative integer number. Since there is no positive integer value of 2147483648, I added +1 to the maximum negative number 
				if(hours<= -2147483648) {
					hours+=1;
				}
				//System.out.println("Hours are negative. Changing hours to positive");
				hours*=-1;
			}
			
			/**
			 * This if statement is used to check for negative numbers for overtime
			 */
			if (overtime<0) {
				//Implemented to handle the maximum negative integer number. Since there is no positive integer value of 2147483648, I added +1 to the maximum negative number 
				if(overtime <= -2147483648) {
					overtime+=1;
				}
				//System.out.println("Overtime is negative. Changing overtime");
				overtime*=-1;
			}			
			
			//This will check if hours or overtime is over the MAXIMUM_HOURS_ALLOWED
			if (hours > MAXIMUM_HOURS_ALLOWED || overtime > MAXIMUM_HOURS_ALLOWED) {
				return MAX_MONTHLY_WAGE;
			}
			
			
			//This returns the max monthly wage if the hours and overtime total is at least the MAXIMUM_HOURS_ALLOWED
			if(hours + overtime > MAXIMUM_HOURS_ALLOWED) {
				return MAX_MONTHLY_WAGE;
				
			//This if statement check if the overtime and hours total is less than the minimum	
			}else if (hours + overtime < MINIMUM_HOURS_REQUIRED) {
				
				//This turns all negative wages to 0
				if(((hours+overtime) * HOURLY_WAGE) - PENALTY<0){
					return 0.00;
				}
				
				
				return ((hours+overtime) * HOURLY_WAGE) - PENALTY;
			}
			
			// If the total hours for hours and overtime is in between the minimum hours required and maximum hours allowed,
			// and the wages hit over $5000 then this will return the MAX_MONTHLY_WAGE
			// Hours between 243.9 and 250 will change from over $5000 to just $5000
			if((hours+overtime)*HOURLY_WAGE>MAX_MONTHLY_WAGE) {
				return MAX_MONTHLY_WAGE;
			}
			
			
			//If hours+overtime total is between the minimum and maximum hours, then it calculates the wages
			return (hours+overtime)* HOURLY_WAGE;
		
		}
		
		
		
		public void doLegalStuff() {
			//do nothing
			return;
		}
}
