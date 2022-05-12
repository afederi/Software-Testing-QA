
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.*;
import org.junit.runner.RunWith;


@RunWith(MockitoJUnitRunner.class)
public class testPeople {
	
	private final int PHONE_TO_CHECK = 1234;
	
	@Mock
	private CacheManager cache;
	private DiskManager disk;
	
	@InjectMocks
	private Person p = new Person(cache,disk);
	private Person p_alternative = new Person(cache,disk);
	private Person p_null = new Person(cache,disk);
	
	
	@Before
	public void testSet() {
		cache = mock(CacheManager.class);
		disk = mock(DiskManager.class);
		
		p = new Person(cache, disk);
		p.setPerson(PHONE_TO_CHECK, "Steve", "Green");
		
		p_alternative = new Person(cache,disk);
		p_alternative.setPerson(PHONE_TO_CHECK, "John", "Smith");
		
		p_null = new Person(cache,disk);
		p_null.setPerson(PHONE_TO_CHECK, null, null);
	}

	
	@Test
	public void testMockCache() {
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(p);
		
		Assert.assertTrue("Person is in cache",p.equals(cache.getPerson(PHONE_TO_CHECK)));
		
	}
	@Test
	public void testMockDisk() {
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(p);
		Assert.assertTrue("", p.equals(disk.getPerson(PHONE_TO_CHECK)));
	}
	
	@Test
	public void testVerify() {
		cache.addPerson(p);
		
		  
		verify(cache).addPerson(p);
		//the times(0) means that a mockito object was never called
		verify(disk,times(0)).addPerson(p);
	}
	
	
	@Test
	public void testVerify2() {
		cache.addPerson(p);
		cache.addPerson(p);
		cache.addPerson(p);
		
		//This line of code works to only verify 
		//	if the line of code runs only once
		//verify(cache).addPerson(p);	
		
		verify(cache,times(3)).addPerson(p);
		verify(cache,atLeast(2)).addPerson(p);
		verify(cache,atMost(5)).addPerson(p);
	}
	
	@Test
	public void testInOrder() {
		cache.addPerson(p);
		disk.addPerson(p);
		
		//In inOrder(), the order of the mock object do not matter.
		//	It only matters when you begin running the verify method
		InOrder testInorder = inOrder(disk, cache);
		
		//This commented line of code below will not complete the test because
		//	the disk mockito was not called first. It was cache.
		//testInorder.verify(disk).addPerson(p);
		testInorder.verify(cache).addPerson(p);
		testInorder.verify(disk).addPerson(p);
		
	}
	
	
	
	//Testing equals when the phone number is in cache
	@Test
	public void testEquals() {
		
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(p);
		
		
		boolean b = p.equals(cache.getPerson(PHONE_TO_CHECK));
		
		
		verify(cache).getPerson(PHONE_TO_CHECK);
		verify(disk,times(0) ).getPerson(PHONE_TO_CHECK);
		Assert.assertEquals("This tests the cache",true, b);
	}
	
	//Testing  equals when the phone number is not in cache
	/**
	 * NOTE: the equals method in Person cannot handle null pointer exceptions.
	 * 		  Method was edited to handle a null object
	 */
	@Test
	public void testEquals2() {
		
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(null);
		
		boolean b = p.equals(cache.getPerson(PHONE_TO_CHECK));
		
		verify(cache).getPerson(PHONE_TO_CHECK);
		verify(disk, times(0)).getPerson(PHONE_TO_CHECK);		
		Assert.assertEquals("This test the cache when there is no hit", false, b);
	}
	
	//Testing equals when the phone number in cache is the same, but the names are different?
	@Test
	public void testEquals3() {
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(p_alternative);
		
		boolean b = p.equals(cache.getPerson(PHONE_TO_CHECK));
		
		verify(cache).getPerson(PHONE_TO_CHECK);
		verify(disk, times(0)).getPerson(PHONE_TO_CHECK);
		Assert.assertEquals("This test the cache when the number is the same but different names", false, b);
	}
	
	//Testing equals when the phone number in cache exists, but the names for both name and last name are null
	@Test
	public void testEqualse4() {
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(p_null);
		boolean b = p.equals(cache.getPerson(PHONE_TO_CHECK));
		
		verify(cache).getPerson(PHONE_TO_CHECK);
		verify(disk, times(0)).getPerson(PHONE_TO_CHECK);
		Assert.assertEquals("This tests the cache when the number is the same, but the person's name is all null", false, b);
	}
	
	//Testing equals when the phone number in disk exists
	@Test
	public void testEquals5() {
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(p);
		
		boolean b = p.equals(disk.getPerson(PHONE_TO_CHECK));
		
		verify(cache, times(0)).getPerson(PHONE_TO_CHECK);
		verify(disk).getPerson(PHONE_TO_CHECK);
		Assert.assertEquals("This tests the cache",true, b);

	}
	
	//Testing equals when the phone number in disk does not exist
	@Test
	public void testEquals6() {
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(null);
		
		boolean b = p.equals(disk.getPerson(PHONE_TO_CHECK));
		
		verify(cache, times(0)).getPerson(PHONE_TO_CHECK);
		verify(disk).getPerson(PHONE_TO_CHECK);
		Assert.assertEquals("This tests the cache",false, b);
	}
	
	//Testing equals when the phone number is in disk, but there is a different name
	@Test
	public void testEquals7() {
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(p_alternative);
		
		boolean b = p.equals(disk.getPerson(PHONE_TO_CHECK));
		
		verify(cache, times(0)).getPerson(PHONE_TO_CHECK);
		verify(disk).getPerson(PHONE_TO_CHECK);
		Assert.assertEquals("This tests the cache",false, b);
	}
	
	//Testing equals when the phone number is in disk, but the first name and last name are null
	@Test
	public void testEquals8() {
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(p_null);
		
		boolean b = p.equals(disk.getPerson(PHONE_TO_CHECK));
		
		verify(cache, times(0)).getPerson(PHONE_TO_CHECK);
		verify(disk).getPerson(PHONE_TO_CHECK);
		Assert.assertEquals("This tests the cache",false, b);
	}
	
	
	/**
	 * The test below tests the getFullName() Method
	 */
	
	//Testing getFull name when the number is found in Cache
	@Test
	public void testGetFullName() {
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(p);
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(null);
		
		String og = "Steve Green";
		String name = p.getFullName();
		

		InOrder testInorder = inOrder(disk, cache);
		testInorder.verify(cache).getPerson(PHONE_TO_CHECK);
		//The disk does not get called because cache.getPerson(PHONE_TO_CHECK) is never null
		testInorder.verify(disk,times(0)).getPerson(PHONE_TO_CHECK);
		Assert.assertEquals("Phone number found in cache", og, name);
	}
	
	//Testing getFullName() when the number is found in disk but not in Cache
	public void testGetFullName2() {
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(null);
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(p);
		
		String og = "Steve Green";
		String name = p.getFullName();

		InOrder testInorder = inOrder(disk, cache);
		testInorder.verify(cache).getPerson(PHONE_TO_CHECK);
		testInorder.verify(disk).getPerson(PHONE_TO_CHECK);
		
		Assert.assertEquals("Phone number should be found in disk", og, name);
	}
	
	//Testing getFullName() when the number is not found in neither disk nor Cache
	public void testGetFullName3() {
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(null);
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(null);
		
		String og = "";
		String name = p.getFullName();

		InOrder testInorder = inOrder(disk, cache);
		testInorder.verify(cache).getPerson(PHONE_TO_CHECK);
		testInorder.verify(disk).getPerson(PHONE_TO_CHECK);
		
		Assert.assertEquals("Phone number not found", og, name);
	}
	
	
	//Testing getFull name when the number is found in Cache 
	//first and last names are null
	@Test
	public void testGetFullName4() {
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(p_null);
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(null);
		
		String og = "null null";
		String name = p.getFullName();
			

		InOrder testInorder = inOrder(disk, cache);
		testInorder.verify(cache).getPerson(PHONE_TO_CHECK);
		testInorder.verify(disk, times(0)).getPerson(PHONE_TO_CHECK);
			
		Assert.assertEquals("Phone number should found in cache", og, name);
		}
		
		//Testing getFullName() when the number is found in disk but not in Cache 
		//first and last names are null
	@Test
	public void testGetFullName5() {
		when(cache.getPerson(PHONE_TO_CHECK)).thenReturn(null);
		when(disk.getPerson(PHONE_TO_CHECK)).thenReturn(p_null);
			
		String og = "null null";
		String name = p.getFullName();
		

		InOrder testInorder = inOrder(disk, cache);
		testInorder.verify(cache).getPerson(PHONE_TO_CHECK);
		testInorder.verify(disk).getPerson(PHONE_TO_CHECK);
			
		Assert.assertEquals("Phone number should be found in disk", og, name);
		}
}

