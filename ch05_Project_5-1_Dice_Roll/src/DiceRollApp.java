import java.util.Scanner;

public class DiceRollApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String choice = "";
		
		System.out.println("Dice Roller ");
		
		System.out.println("Roll the dice? (y/n): ");
		choice = sc.next();
		
		do {
			double die1 = (Math.random()* 6) + 1;
			double die2 = (Math.random()* 6) + 1;
			double total = (int)die1 + (int)die2;
		
			System.out.println("Die 1: " + (int)die1);
			System.out.println("Die 2: " + (int)die2);
			System.out.println("Total: " + (int)total);
		
			if((int)die1 == 1 & (int)die2 == 1) {
				System.out.println("Snake eyes! ");
			}else if ((int)die1 == 6 & (int)die2 == 6) {
				System.out.println("Boxcars! ");
			}
		
		System.out.println("Roll agian? (y/n): ");
		choice = sc.next();
		
		}while(choice.equalsIgnoreCase("y"));
		
		sc.close();
		System.out.println("Goodbye! ");
		
	}
	
		
}
