package ch03_prj_3_3InterestCalculator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Interest Calculator App!\n ");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			double loanAmt, interestRate, interest = 0.0;
			
			System.out.print("Enter loan amount: ");
			//BigDecimal loanAmt = sc.nextBigDecimal();
			loanAmt = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Enter interest rate: ");
			interestRate = sc.nextDouble();
			sc.nextLine();
			
			BigDecimal loanAmtBD = new BigDecimal(loanAmt);
			BigDecimal interestRateBD = new BigDecimal(interestRate);
			
			interest = loanAmtBD.multiply(interestRateBD).doubleValue();
			
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			
			currency.setMaximumFractionDigits(2);
			percent.setMaximumFractionDigits(3);
			
			String loanAmtString = currency.format(loanAmt);
			String interestRateString = percent.format(interestRate);
			String interestString = currency.format(interest);
			
			System.out.println("Loan amount: \t\t\t" + loanAmtString);
			System.out.println("Interest rate: \t\t" + interestRateString);
			System.out.println("Interest:\t\t\t" + interestString);
			
			System.out.print("Continue?  (y/n:)");
			choice = sc.nextLine();
			
		}
		
		System.out.println("Goodbye!");
		sc.close();

	}

}
