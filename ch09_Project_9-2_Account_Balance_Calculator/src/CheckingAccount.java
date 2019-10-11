
public class CheckingAccount extends Account {
	
	private double monthlyFee;
	
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(double balance, double monthlyFee) {
		super(balance);
		this.monthlyFee = monthlyFee;
	}
	
	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public double subtractFee() {
		setBalance(balance - monthlyFee);
		return monthlyFee;
	}
	
	public String toString() {
		String message = "Checkings: " + balance+ "\n"
						+"Fees: " + monthlyFee;
		return message;
	}
	
}
