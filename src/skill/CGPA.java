//		190031187 RADHAKRISHNA

package skill;

import java.util.*;

public class CGPA {
	Scanner s=new Scanner(System.in);
	private ArrayList<String> course;
	private ArrayList<Integer> marks;
	private ArrayList<Double> credits;
	private ArrayList<Character> grades;
	private ArrayList<Integer> pts;
	private int n;
	public CGPA() {
		this.course = new ArrayList<String>();
		this.marks = new ArrayList<Integer>();
		this.credits = new ArrayList<Double>();
		this.grades = new ArrayList<Character>();
		this.pts = new ArrayList<Integer>();
		this.n=0;
	}
//	public void input() {
//		System.out.println("Enter number of subjects:");
//		n= s.nextInt();
//		for(int i=0;i<n;i++) {
//			System.out.println("Enter course name");
//			course.add(s.next());
//			System.out.println("Enter course credits");
//			credits.add(s.nextDouble());
//			System.out.println("Enter marks obtained in that course");
//			marks.add(s.nextInt());
//			grades.add(grade(marks.get(i)));
//			pts.add(points(grades.get(i)));	
//		}
//		mainmenu(n);
//	}
	public void mainmenu() {
		boolean repeat=true;
		while(repeat) {
			switch(submenu()) {
				case 1:
					addCourse(s.next(),s.nextDouble(),s.nextInt());
					break;
				case 2:
					delCourse(s.next());
					break;
				case 3:
					changeDetails(s.next(),s.next(),s.nextDouble(),s.nextInt());
					break;
				case 4:
					calculator();
					break;
				default:
					repeat=false;
			}
		}
	}
	private int submenu() {
		System.out.println("Available operations:");
		System.out.println("1.Add a course");
		System.out.println("2.Delete a course");
		System.out.println("3.Change course Details");
		System.out.println("4.Percentage calculation");
		System.out.println("Enter any other number to exit");
		System.out.println("Choose your option:");
		return s.nextInt();
	}
	
	private char grade(int m) {
		char x=' ';
		if(m>=90 && m<=100) { x='O';}
		else if(m>=80 && m<90) {  x='A';}
		else if(m>=70 && m<80) {  x='B';}
		else if(m>=70 && m<60) {  x='C';}
		else if(m>=60 && m<50) {  x='D';}
		else if(m<=50) {  x='F';}
		else {
//			System.out.println("Invalid Marks Try again From First!!");
		}
		return x;
	}
	private int points(char c) {
		int z=0;
		if(c=='O') {z= 10;}
		else if(c=='A') {z=9;} 
		else if(c=='B') {z=8;} 
		else if(c=='C') {z=7;} 
		else if(c=='D') {z=6;} 
		else if(c=='F') {z=5;} 
		return z;
	}
	
	private void calculator() {
		float cgpa;
		float sum=0,total=0;
		for(int i=0;i<n;i++) {
			sum+=credits.get(i)*pts.get(i);
			total+=credits.get(i);
		}
		cgpa=sum/total;
		System.out.println("Course\t\tCredits\tMarks\tPoint\tGrades");
		for(int i=0;i<n;i++) {
			System.out.println(course.get(i)+"\t\t"+credits.get(i)+"\t"+marks.get(i)+"\t"+pts.get(i)+"\t"+grades.get(i));
		}
		System.out.printf("CGPA: %.2f\n",cgpa);
	}
	
	public void addCourse(String name,Double cdts,int mark) {
		n=n+1;
//		System.out.println("You are ready to add your course");
//		System.out.println("Enter course name");
		course.add(name);
//		System.out.println("Enter course credits");
		credits.add(cdts);
//		System.out.println("Enter marks obtained in that course");
		marks.add(mark);
		grades.add(grade(marks.get(n-1)));
		pts.add(points(grades.get(n-1)));
//		calculator();
	}
	
	private int searchCourse(String name) {
		for(int i=0;i<n;i++) {
			if(course.get(i).equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean delCourse(String name) {
//		System.out.println("Enter course name you want to delete:");
		int j=searchCourse(name);
		if(j!=-1) {
			course.remove(j);
			credits.remove(j);
			marks.remove(j);
			grades.remove(j);
			pts.remove(j);
			n=n-1;
//			System.out.println("Deleted the course Successfully");
//			calculator();
			return true;
		}
//		System.out.println("No such course exists");
//		calculator();
		return false;
	}
	
	public boolean changeDetails(String name,String newname,Double newcdts,int newmark) {
//		System.out.println("Enter course name you want to change details:");
		int j=searchCourse(name);
		if(j!=-1) {
			course.remove(j);
			credits.remove(j);
			marks.remove(j);
			grades.remove(j);
			pts.remove(j);
//			System.out.println("You are ready to change your course");
//			System.out.println("Enter course name");
			course.add(newname);
//			System.out.println("Enter course credits");
			credits.add(newcdts);
//			System.out.println("Enter marks obtained in that course");
			marks.add(newmark);
			grades.add(grade(marks.get(n-1)));
			pts.add(points(grades.get(n-1)));
//			System.out.println("Changes are done Successfully");
//			calculator();
			return true;
		}
//		System.out.println("No such course exits");
//		calculator();
		return false;
	}
	
	public double TestCGPACalulator() {
		double cgpa;
		double sum=0,total=0;
		for(int i=0;i<n;i++) {
			sum+=credits.get(i)*pts.get(i);
			total+=credits.get(i);
		}
		cgpa=sum/total;
		return cgpa;
	}

}