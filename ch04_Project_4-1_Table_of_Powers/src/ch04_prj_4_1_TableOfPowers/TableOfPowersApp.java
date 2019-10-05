package ch04_prj_4_1_TableOfPowers;

import java.util.Scanner;

public class TableOfPowersApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Squares and Cubes! \n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		int c = 0; //increment counter
		
		while(choice.equalsIgnoreCase("y")) {
			
			System.out.println("Enter a whole number");
			int n = sc.nextInt();
			System.out.println("Number\tSquared\tCubbed");
			System.out.println("======\t======\t======");
			
			for (int i=1;i<=n;i++) {
				System.out.println(i + "\t" + i*i + "\t" + i*i*i);
			}
			c++; // increment counter
			System.out.println("You have played " +c+ " times. ");
			System.out.println("Continue (y/n)");
			choice = sc.next();
		}
		
		sc.close();
		
		System.out.println("Goodbye");
		
		}
}


