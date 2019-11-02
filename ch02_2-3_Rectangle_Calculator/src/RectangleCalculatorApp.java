
public class RectangleCalculatorApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Area and Perimeter Calculator");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			int length = Console.getInt("Enter length: ");
			int width = Console.getInt("Enter width: ");
			
			double area = (double)length * (double)width;
			double perimeter = ((double)length * 2)+((double)width * 2);
			
			System.out.println("Area: " + area);
			System.out.println("Perimeter: " + perimeter);
			
			choice = Console.getString("Continue? (y/n)");
			
		}
		

	}

}
