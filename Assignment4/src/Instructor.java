/**
 * This class inherit from the Person class, and implemented the getStatus method.
 * 
 * Last date edit: Mar 27th
 * 
 *  @ changsong Li
 * 
 */
public class Instructor extends Person {

	public Instructor(String n, String s) {
		super(n, s);
	}

	@Override
	public String getStatus() {
		return status;
	}

}
