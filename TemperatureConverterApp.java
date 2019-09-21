package ch03_prj_3_1_TemperatureConverter;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			
			System.out.println("\nWelcome to the Temperature Converter!\n");
			System.out.print("Enter degrees in Fahrenheit: ");
			
			double degreesInFahrenheit = sc.nextDouble();
			double degreesInCelcsius = ((degreesInFahrenheit - 32) * 5/9);
			DecimalFormat df = new DecimalFormat("#.##");
			degreesInCelcsius = Double.valueOf(df.format(degreesInCelcsius));

			System.out.println("Degrees in Celcsius: " + degreesInCelcsius + "\n");
			
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			
		}
		
		sc.close();
		System.out.println("\nGoodbye\n");
	}

}
