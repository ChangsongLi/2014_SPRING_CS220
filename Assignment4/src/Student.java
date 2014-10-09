/**
 * This class inherit from the Person class, and implemented the getStatus method.
 * 
 * Last date edit: Mar 27th
 * 
 *  @ changsong Li
 * 
 */
public class Student extends Person {

	public Student(String n, String s) {
		super(n, s);
	}
	
	public String getStatus(){
		return status;
	}

}
