/**
 * This program is to find the smallest name among the students from the data.txt.
 * 
 * Last date edit: Mar 27th
 * 
 *  @ changsong Li
 * 
 */

import java.io.*;
import java.util.Scanner;
import java.util.Vector;


public class Driver {

	public static void main(String[] args) {
		new Driver();
	}
	
	@SuppressWarnings("resource")
	public Driver(){
		try{
			BufferedReader reader = new BufferedReader( new FileReader("data.txt") );
			Vector<Person> collection = new Vector<Person>(10,1);
			
			String line = reader.readLine();
			while( line != null ){
				Scanner scan = new Scanner( line );
				String name = scan.next();
				int status = scan.nextInt();
				if( status == 1 )
					collection.add( new Student(name,"Student"));
				else if(status == 2)
					collection.add( new Instructor(name,"Instructor"));
				line = reader.readLine();
			}
			int index = -1;
			for (int i = 0; i < collection.size(); i++ ){
				if (collection.elementAt(i).status.equals("Student")){
					if(index == -1){
						index = i;
					}
					else{
						if (collection.elementAt(index).compareTo(collection.elementAt(i)) > 0 ){
							index = i;
						}
					}
				}
			}
			System.out.println("The smallest name among the students is " + collection.elementAt(index).name + ".");
			reader.close();
			
			
		}
		catch( IOException i){
			System.out.println("IOException.");
		}
	}

}
