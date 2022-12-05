package PaymentMethod;

public class CreditCard implements IPayment{
	private String paymentName = "CreditCard";
	private double amount;
	private String creditCardNumber;
	
	public CreditCard(String creditCardNumber,double amount) {
		this.amount=amount;
		this.creditCardNumber=creditCardNumber;
	}
	
	@Override
	public boolean withdraw(double amount) {
		if(amount>this.amount) {
			return false;
		}
		this.amount=this.amount-amount;
		return true;
	}
	
	public String getCreditCardNumber() {
		return creditCardNumber;
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
