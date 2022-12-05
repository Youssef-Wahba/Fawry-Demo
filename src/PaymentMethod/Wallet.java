package PaymentMethod;

public class Wallet implements IPayment{
	private String paymentName = "Wallet";
	private double amount;
	
	public Wallet(double amount) {
		this.amount=amount;
	}
	
	@Override
	public boolean withdraw(double amount) {
		if(amount>this.amount) {
			return false;
		}
		this.amount=this.amount-amount;
		return true;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void addFund(double amount) {
		this.amount+=this.amount=amount;
	}
	
	public String getPaymentName() {
		return paymentName;
	}

}
