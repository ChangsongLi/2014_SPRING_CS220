/**
 * This abstract class implement comparable interface with property of name and status.
 * It also has a abstract method getStatus.
 * 
 * Last date edit: Mar 27th
 * 
 *  @ changsong Li
 * 
 */
public abstract class Person implements Comparable<Person>{
	protected String name;
	protected String status;
	
	public Person( String n, String s ){
		name = n;
		status = s;
	}
	
	public abstract String getStatus();
	
	public int compareTo( Person p ){
		if (name.compareTo(p.name) > 0)
			return 1;
		else if(name.compareTo(p.name) < 0)
			return -1;
		else
			return 0;
	}
}
