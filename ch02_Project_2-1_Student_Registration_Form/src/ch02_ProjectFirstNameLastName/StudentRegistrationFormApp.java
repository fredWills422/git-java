package ch02_ProjectFirstNameLastName;

import java.util.Scanner;

public class StudentRegistrationFormApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Student Registration Form");
		System.out.print("Enter first name: ");
		String firstName = sc.next();
		System.out.print("Enter last name: ");
		String lastName = sc.next();
		System.out.print("Enter year of birth: ");
		int yearOfBirth = sc.nextInt();
		
		System.out.println("Welcome " + firstName + " " + lastName + "!");
		System.out.println("Your registration is complete.");
		System.out.println("Your temporary password is " + firstName + "*" + yearOfBirth);
		
		sc.close();
	}
	

}
