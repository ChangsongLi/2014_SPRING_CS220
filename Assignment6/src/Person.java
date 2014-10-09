
public class Person implements Comparable<Person>{
	private String lastName,firstName,ssn;
	private static int sort = -1;
	
	public Person( String lsnm, String frnm, String ssnum ){
		lastName = lsnm;
		firstName = frnm;
		ssn = ssnum;
	}

	@Override
	public int compareTo(Person o) {
		if( sort == 3 ){
			try{
				int num = Integer.parseInt(ssn);
				int numO = Integer.parseInt(o.ssn);
				if (num > numO){
					return 1;
				}
				else if (num < numO){
					return -1;
				}
				else{
					return 0;
				}
			}catch(Exception e){
				System.out.println(ssn+"  "+o.ssn+" are not number");
				return 0;
			}
		}
		else if( sort == 2 ){
			if (firstName.compareTo(o.firstName) > 0)
				return 1;
			else if (firstName.compareTo(o.firstName) < 0)
				return -1;
			else
				return 0;
		}
		else{
			if (lastName.compareTo(o.lastName) > 0)
				return 1;
			else if (lastName.compareTo(o.lastName) < 0)
				return -1;
			else
				return 0;			
		}
	}
	
	public void setSort( int i ){
		if ( i <= 3 && i >=1 ){
			sort = i;
		}
	}
	
	public String toString(){
		return ""+lastName+" "+firstName+" "+ssn;
	}
	
	
}
