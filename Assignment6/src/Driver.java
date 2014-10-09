/**
 * Sorting a students' file with lastName, firstName, and SSN. The program will be 
 * sorted by different way by user's input.lastName (1), firstName(2) or SSN(3).
 * 
 * Last date edit: Apr 21th
 * 
 *  @ changsong Li
 * 
 */
import java.io.*;
import java.util.Scanner;
import java.util.Vector;


public class Driver {
	
	public static void main(String[] args){
		if(args.length != 3){
			System.out.println("Missing Command. Command should be InputTextFileName OutpuTextFileName WayToSort");
			System.exit(-1);
		}
		new Driver(args[0],args[1],args[2]);
	}
	
	@SuppressWarnings("resource")
	public Driver(String in,String out, String sor){
				
		Vector<Person> list = new Vector<Person>();
		BufferedReader fin;
		String line,firstLine = "";
		
		try{
			fin = new BufferedReader( new FileReader(in) );
			
			// get rid of first line.
			firstLine = fin.readLine();
			while ( (line = fin.readLine()) != null ){
				Scanner scan = new Scanner(line);
				String fr = "", ls = "", ssn = "";
				if (scan.hasNext())
					ls = scan.next();
				if (scan.hasNext())
					fr = scan.next();
				if (scan.hasNext())
					ssn = scan.next();
				
				if (ssn == ""){
					System.out.println("Database Error");
					System.exit(-2);
				}
				
				Person p = new Person(ls,fr,ssn);
				list.add(p);				
			}
			fin.close();
		}catch(IOException e){
			System.out.println("Wrong input file Name"+in);
			System.exit(-3);
		}
		
		try{
			int sort = Integer.parseInt(sor);
			if (!(sort == 1 || sort == 2 || sort == 3)){
				System.out.println("Sort command is not 1 or 2 or 3,");
				System.exit(-1);
			}
			if (list.size() > 0){
				(list.elementAt(0)).setSort(sort);
			}
		}catch(Exception e){
			System.out.println("Sort command is not a number. "+sor);
		}
		mergeSort(list);
		
		printToTxt( out , firstLine, list );
		
	}
	
	public void printToTxt(String out, String firstLine, Vector<Person> list){
		PrintWriter fout = null;
		try {
			fout = new PrintWriter( new FileWriter(out) );
			fout.println(firstLine);
			for (int i = 0; i < list.size(); i++){
				fout.println(list.elementAt(i).toString());
			}
			fout.flush();
			fout.close();
		} catch(IOException ioe){
			System.out.println("Error writing to "+out);
		}
		
	}

	public void mergeSort(Vector<Person> list){
		if(list.size() < 2) return;
		
		Vector<Person> left = new Vector<Person>();
		Vector<Person> right = new Vector<Person>();
		int middle = list.size()/2;
		
		for (int i = 0; i < middle; i++){
			left.add(list.remove(0));
		}
		
		while(!list.isEmpty()) {
			right.add(list.remove(0));
		}
		
		mergeSort(left);
		mergeSort(right);
		
		merge(left, right, list);
	}
	
	public void merge(Vector<Person> left, Vector<Person> right, Vector<Person> result ){
		while (!left.isEmpty() && !right.isEmpty()){
			Person pL = left.elementAt(0);
			Person pR = right.elementAt(0);
			
			if( pL.compareTo(pR) < 0)
				result.add(left.remove(0));
			else
				result.add(right.remove(0));
		}
		while(!left.isEmpty()){
			result.add(left.remove(0));
		}
		
		while(!right.isEmpty()){
			result.add(right.remove(0));
		}
	}	
}
