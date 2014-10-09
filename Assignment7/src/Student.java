/*
 *  Student class with student's name and GPA. 
 *  
 *   Jason Li
 *   May 7th
 */
public class Student implements Comparable<Student>{
	private String nm;
	private double gp;
	
	public Student(String name,double gpa){
		nm = name;
		gp = gpa;
	}
	
	public double getGPA(){
		return gp;
	}
	
	public String getName(){
		return nm;
	}
	
	public int compareTo(Student o){
		
		if(getGPA() > o.getGPA())
			return 1;
		else if(getGPA() > o.getGPA())
			return 0;
		else
			return -1;
	}
	
	public boolean equals(Student o){
		if(getName().equals(o.getName()))
			return true;
		else
			return false;
			
	}
	
	public String toString(){
		return nm+"  "+gp;
	}
}
