import java.util.Scanner;

public class AccountBalanceApp {

	public static void main(String[] args) {
		
		Account checkingAccount1 = new CheckingAccount(1000.0, 1.0); //polymorphism
		Account savingsAccount1 = new SavingsAccount(1000.0, 0.01);//polymorphism
		Scanner sc = new Scanner(System.in);
		
		String choiceContinue = "";
		String choiceWithdrawalOrDeposit = "";
		String choiceCheckingOrSavings = "";
		
		System.out.println("Welcome to the Account application\n"); 
		System.out.println("Starting Balances"
						  +"\nCheckings: " +checkingAccount1.balance+ "\n"
						  +"Savings: " +savingsAccount1.balance+ "\n");
		
		do {
			System.out.println("Enter the transactions for the month\n");
			
			System.out.print("Withdrawal or deposit? (w/d): ");
			choiceWithdrawalOrDeposit = sc.next();
			
			System.out.print("Checking or savings? (c/s): ");
			choiceCheckingOrSavings = sc.next();
			
			System.out.print("Amount?: ");
			double amount = sc.nextDouble();
			
			if(choiceWithdrawalOrDeposit.equalsIgnoreCase("w") && 
					choiceCheckingOrSavings.equalsIgnoreCase("c")) {
					checkingAccount1.withdraw(amount);
			}
			if(choiceWithdrawalOrDeposit.equalsIgnoreCase("w") && 
					choiceCheckingOrSavings.equalsIgnoreCase("s")) {
					savingsAccount1.withdraw(amount);
			}
			if(choiceWithdrawalOrDeposit.equalsIgnoreCase("d") && 
					choiceCheckingOrSavings.equalsIgnoreCase("c")) {
					checkingAccount1.deposit(amount);
			}
			if(choiceWithdrawalOrDeposit.equalsIgnoreCase("d") && 
					choiceCheckingOrSavings.equalsIgnoreCase("s")) {
					savingsAccount1.deposit(amount);
			}
			
			System.out.print("\nContinue? (y/n): ");
			choiceContinue = sc.next();
			System.out.println("");
			
		}while (choiceContinue.equalsIgnoreCase("y"));
		
		sc.close();
		
		((SavingsAccount) savingsAccount1).pay();
		((CheckingAccount) checkingAccount1).subtractFee();
		
		System.out.println("Monthly Payments and Fees\n"
				+"Checking fee: " +"\t"+ ((CheckingAccount)checkingAccount1).getMonthlyFee()+"\n" //polymorphism
				+"Savings interest payment: " + ((SavingsAccount)savingsAccount1).getMonthlyInterestPayment()+ "\n");//polymorphism
		
		System.out.println("Final Balances"
				  +"\nCheckings: " +checkingAccount1.balance+ "\n"
				  +"Savings: " +savingsAccount1.balance+ "\n");
	}

}
