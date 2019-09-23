import java.util.Scanner;

public class FractorialCalculatorApp {

	public static void main(String[] args) {
		
		String choice = "y";
		Scanner sc = new Scanner(System.in);
		
		while(choice.equalsIgnoreCase("y")) {
			
			System.out.println("Welcome to the Fractorial Calculator! ");
		
			System.out.println("Enter a interger that is greater than 0 and less than 10: ");
			long n = sc.nextLong();
			long fractorial=1;
		
			for (long i=1;i<n;i++) {
			
				fractorial = fractorial * i;
			
			}
			
			System.out.println("The fractorial of " +n+ " is: " + n*fractorial);
			System.out.println("Continue? (y/n) ");
			choice = sc.next();
			
		}
		
		sc.close();
		System.out.println("Goodbye! ");
		
		
	}

}
