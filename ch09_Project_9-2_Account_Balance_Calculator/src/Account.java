
public class Account implements Balanceable, Depositable, Withdrawable {
	
	protected double balance;
	
	public Account() {
		
	}
	
	public Account(double balance) {
		this.balance =  balance;
	}

	@Override
	public double getBalance() {
		return balance;
	}
	
	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public void withdraw(double amount) {
		this.balance = balance - amount;
	}

	@Override
	public void deposit(double amount) {
		this.balance = balance + amount;
	}


}
