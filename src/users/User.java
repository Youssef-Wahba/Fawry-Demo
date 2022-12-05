package users;

import PaymentMethod.CreditCard;
import PaymentMethod.Wallet;

public class User implements IPerson {
	private String userName,email,password;
	boolean isLoggedIn;
	private Wallet wallet;
	private CreditCard creditCard;
	
	public User(){
		this.email="";
		this.password="";
		this.userName="";
		this.isLoggedIn = false;
	}
	
	public User(String userName,String email,String password,String creditCardNumber,double amount){
		this.email=email;
		this.password=password;
		this.userName=userName;
		this.isLoggedIn = false;
		this.wallet=new Wallet(0);
		this.creditCard=new CreditCard(creditCardNumber,amount);		
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public void setIsLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	public Wallet getWallet() {
		return wallet;
	}
	
	public CreditCard getCreditCard() {
		return creditCard;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUserName() {
		return userName;
	}
	
	@Override
	public boolean getIsLoggedIn() {
		return isLoggedIn;
	}
}