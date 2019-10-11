
public class SavingsAccount extends Account {
	
	private double monthlyInterestRate;
	private double monthlyInterestPayment;
	
	public SavingsAccount(){
		
	}
	
	public SavingsAccount(double balance, double monthlyInterestRate) {
		super(balance);
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}
	
	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}
	
	public void setMonthlyInterestPayment(double monthlyInterestPayment) {
		this.monthlyInterestPayment = monthlyInterestPayment;
	}

	private double calculatePayment() {
		monthlyInterestPayment = balance * monthlyInterestRate;	
		return monthlyInterestPayment;
	}
	
	public void pay() {
	calculatePayment();	
	deposit(monthlyInterestPayment);
	}
	
	public String toString() {
		String message = "Savings: " + balance+ "\n"
						+"Monthly interest rate: " +monthlyInterestRate+ "\n"
						+"Monthly interest payment: " + monthlyInterestPayment;
		return message;
	}
	
}
