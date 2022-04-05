import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestClasses {
	
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
	
	
	
	@Test
	public void testBlank() {
		boolean a=StringUtils.isBlank(null);
		
		Assert.assertEquals("This is null test", true, a);
		
		
		
	}
	
	@Test
	public void testBlank2() {
		boolean a=StringUtils.isBlank("");
		
		Assert.assertEquals("This is null test", true, a);
	}
	
	@Test
	public void testBlank3() {
		boolean a = StringUtils.isBlank("bob");
		
		Assert.assertEquals(" This is a null test", false, a);
	}
	
	@Test
	public void testBlank4() {
		boolean a = StringUtils.isBlank(" bob ");
		
		Assert.assertEquals(" This is a null test", false, a);
	}
	
	
	
	
	
/**
	
	public static boolean isBlank(final CharSequence cs) {
		
		
		int strLen;
		if (cs ==null || (strLen=cs.length())==0) {
			return true;
		}
		for (int i=0; i<strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
		
		
		
	}
	**/

	

	
}
