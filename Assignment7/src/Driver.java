/*
 *  Read the student information from a file, create students object depending on their name and
 *  GPA. Then put them on the list. Each time, it will put the student in the right position by their GPA
 *  to keep the list ascending.
 *  
 *   Jason Li
 *   May 7th
 */
import java.io.*;
import java.util.Scanner;


public class Driver {

	public static void main(String[] arg){
		
		new Driver();
		
	}

	public Driver(){
		try{
			BufferedReader fin = new BufferedReader(new FileReader("Student.txt"));
			String line;
			SinglyLinkedList list = new SinglyLinkedList();
			
			while( (line = fin.readLine()) != null ){
				Scanner scan = new Scanner(line);
				String name = scan.next();
				String gp = scan.next();
				double gpa;
				gpa = Double.parseDouble(gp);
				Student s = new Student(name,gpa);
				list.add(s);
				scan.close();
			}
			fin.close();
			list.print();
			
			
		}catch(Exception e){
			System.out.println("An exception!!!!!!");
		}
	}
}
