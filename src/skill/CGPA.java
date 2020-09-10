package skill;

import java.util.Scanner;

public class CGPA {
	Scanner s=new Scanner(System.in);
	private String[] course;
	private int[] marks;
	private double[] credits;
	private char[] grades;
	private int[] pts;
	private int n;
	public CGPA() {
		System.out.println("Enter number of subjects:");
		n= s.nextInt();
		this.course = new String[n];
		this.marks = new int[n];
		this.credits = new double[n];
		this.grades = new char[n];
		this.pts = new int[n];
	}
	public void init() {
		for(int i=0;i<n;i++) {
			course[i]=s.next();
			credits[i]=s.nextDouble();
			marks[i]=s.nextInt();
			grades[i]=grade(marks[i]);
			pts[i]=points(grades[i]);	
		}
		opts(n);
	}
	public void opts(int n) {
		int d;
		System.out.println("Available operations: \n1.Add a course\n2.Delete a course\n3.Change course Details\n4.Percentage caluculation");
		System.out.println("\nChoose your option:");
		while((d=s.nextInt())!=0) {
			System.out.println("\nChoose your option:");
			if(d==1) {
				int k=addCourse();
				printres(k,pts);
			}
			if(d==2) {
				int j= delCourse(n);
				printres(j,pts);
			}
			if(d==3) {
				changeDetails();
				printres(n,pts);
			}
			if(d==4){
				printres(n+1,pts);
			}
		}
	}
	public char grade(int m) {
		char x=' ';
		if(m>=90 && m<=100) { x='O';}
		else if(m>=80 && m<90) {  x='A';}
		else if(m>=70 && m<80) {  x='B';}
		else if(m>=70 && m<60) {  x='C';}
		else if(m>=60 && m<50) {  x='D';}
		else if(m<=50) {  x='F';}
		else {System.out.println("Invalid Marks Try again!!"); init();}
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
	public void printres(int n,int[] s) {
		float cgpa;float sum = 0;
		for(int i=0;i<n;i++) {
			sum+=pts[i];
		}
		cgpa=sum/n;
		System.out.println("Course  Credits   Marks  Points  Grades");
		for(int i=0;i<n;i++) {
			System.out.println(course[i]+"\t  "+credits[i]+"\t   "+marks[i]+"\t   "+pts[i]+"\t    "+grades[i]);
		}
		System.out.printf("CGPA: %.2f",cgpa);
	}
	public int addCourse() {
		System.out.println("Enter number of subj you entered till now:");
		int n=s.nextInt();
		System.out.println("You are ready to add your course");
			course[n]=s.next();
			credits[n]=s.nextDouble();
			marks[n]=s.nextInt();
			grades[n]=grade(marks[n]);
			pts[n]=points(grades[n]);
			n+=1;return n;
	}
	public int delCourse(int n) {
		System.out.println("Enter course number you want to delete:");
		int f=s.nextInt();
		for(int i=f;i<course.length;i++) {
			course[i-1]=course[i];
			credits[i-1]= credits[i];
			marks[i-1]= marks[i];
			grades[i-1]=grades[i];
			pts[i-1]=pts[i];
			if(course[i]==null) {break;}
			n=-1;
		}
		return n;
	}
	public void changeDetails() {
		System.out.println("enter number of the course to change details:");int n=s.nextInt();
		System.out.println("enter name of the course to change:");
		course[n-1]=s.next();
		System.out.printf("\nenter new credits of the course %s :",course[n-1]);
		credits[n-1]=s.nextDouble();
		System.out.printf("\nenter new marks of the course %s:",course[n-1]);
		marks[n-1]=s.nextInt();
		grades[n-1]=grade(marks[n-1]);
		pts[n-1]=points(grades[n-1]);
		
	}

}