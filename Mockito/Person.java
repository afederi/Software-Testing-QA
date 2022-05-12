public class Person {

    private int phoneNumber;
    private String firstName;
    private String lastName;
    private CacheManager cache;
    private DiskManager disk;

    public Person(CacheManager cache, DiskManager disk) {
        this.cache = cache;
        this.disk = disk;
    }

    public void setPerson(int phoneNumber, String firstName, String lastName) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    /**
     * 
     * @param p
     * @return
     * This equals method has a bug in it in that it doesn't handle 
     * null values, so it goes straight to a null pointer exceptions
     * 
     */
    public boolean equals(Person p) {
               	
    	//Added code [p!=null] to handle null pointer exceptions
    	if (p!=null && this.phoneNumber == p.phoneNumber
                && this.firstName.equals(p.firstName)
                && this.lastName.equals(p.lastName) ) {
            return true;
        }
        return false;
    }

    public String getFullName() {
        Person foundPerson = cache.getPerson(phoneNumber);
        if (foundPerson == null) {
            foundPerson = disk.getPerson(phoneNumber);
        }
        if (foundPerson == null) {
            return "";
        }
        return foundPerson.firstName + " " + foundPerson.lastName;
    }
}
