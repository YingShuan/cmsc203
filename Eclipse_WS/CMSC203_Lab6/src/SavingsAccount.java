
public class SavingsAccount extends BankAccount{
	private double rate = 0.025;
	private int savingsNumer = 0;
	private String accountNumber;
	
	public SavingsAccount (String name, double amount) {
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + String.valueOf(savingsNumer);
	}
	public SavingsAccount (SavingsAccount oldAccount, double amount) {
		super(oldAccount, amount);
		accountNumber = super.getAccountNumber() + "-" + String.valueOf(++savingsNumer);
	}
	
	public void postInterest() {
		double amount = getBalance() * (rate / 12); 
		deposit(amount);
	}
	
	public String getAccountNumber() {	
		return accountNumber;
	}
	
}
