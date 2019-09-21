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
			double degreesInCelcius = ((degreesInFahrenheit - 32) * 5/9);
			DecimalFormat df = new DecimalFormat("#.##");
			degreesInCelcius = Double.valueOf(df.format(degreesInCelcius));

			System.out.println("Degrees in celcius: " + degreesInCelcius + "\n");
			
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			
		}
		
		sc.close();
		System.out.println("\nGoodbye\n");
	}

}
