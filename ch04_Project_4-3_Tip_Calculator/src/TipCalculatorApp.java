import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();
		currency.setMaximumFractionDigits(2);
		percent.setMaximumFractionDigits(2);
		String choice="y";
		
		while(choice.equalsIgnoreCase("y")) {
			
			System.out.println("Welcome to the Tip Calculator! ");
			System.out.print("Enter cost of meal: ");
			BigDecimal costOfMeal = sc.nextBigDecimal();
			
			
			BigDecimal tp15 = new BigDecimal (".15");
			BigDecimal tipA15 = costOfMeal.multiply(tp15); 
			BigDecimal totalA15 = costOfMeal.add(tipA15);
			
			String tipAmount15 = currency.format(tipA15);
			String tipPercent15 = percent.format(tp15);
			String totalAmount15 = currency.format(totalA15);
			
			System.out.println(tipPercent15);
			System.out.println("Tip amount: " + "\t" +  tipAmount15);
			System.out.println("Total amount: " + "\t" +  totalAmount15);
			
			
			BigDecimal tp20 = new BigDecimal (".20");
			BigDecimal tipA20 = costOfMeal.multiply(tp20); 
			BigDecimal totalA20 = costOfMeal.add(tipA20);
			
			String tipAmount20 = currency.format(tipA20);
			String tipPercent20 = percent.format(tp20);
			String totalAmount20 = currency.format(totalA20);
			
			System.out.println(tipPercent20);
			System.out.println("Tip amount: " + "\t" +  tipAmount20);
			System.out.println("Total amount: " + "\t" +  totalAmount20);
			
			
			BigDecimal tp25 = new BigDecimal (".25");
			BigDecimal tipA25 = costOfMeal.multiply(tp25); 
			BigDecimal totalA25 = costOfMeal.add(tipA25);
			
			String tipAmount25 = currency.format(tipA25);
			String tipPercent25 = percent.format(tp25);
			String totalAmount25 = currency.format(totalA25);
			
			System.out.println(tipPercent25);
			System.out.println("Tip amount: " + "\t" + tipAmount25);
			System.out.println("Total amount: " + "\t" +  totalAmount25);
			
			System.out.print("Continue?  (y/n): ");
			choice = sc.next();
			
		}
		
		sc.close();
		System.out.println("Goodbye. ");

	}

}
