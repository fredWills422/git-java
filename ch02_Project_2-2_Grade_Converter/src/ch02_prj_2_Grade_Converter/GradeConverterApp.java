package ch02_prj_2_Grade_Converter;

import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Grade Converter!\n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
		
		System.out.print("Enter a numerical grade: ");
		int numGrade = sc.nextInt();
		
		String letGrade = "";
		if (numGrade >= 88 && numGrade <= 100) {
			letGrade = "A";
		}if (numGrade >= 80 && numGrade < 88) {
			letGrade = "B";
		}if (numGrade >= 67 && numGrade < 80) {
			letGrade = "C";
		}if(numGrade >= 60 && numGrade < 67) {
			letGrade = "D";
		}if (numGrade < 60) {
			letGrade = "F";
		}
		
		System.out.println("Letter grade: " + letGrade);
		
		System.out.print("Continue? (y/n): ");
		choice = sc.next();
		
		
		
		}
		
		System.out.println("Goodbye");
		sc.close();
	}

}
