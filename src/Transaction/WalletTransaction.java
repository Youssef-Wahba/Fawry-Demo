package Transaction;

import java.io.IOException;
import java.util.Date;

import Handlers.FileHandler;
import users.User;

public class WalletTransaction implements ITransaction{
	private User user;
	private double amount;
	FileHandler fh = new FileHandler();
	public WalletTransaction(User user,double amount) {
		this.user = user;
		this.amount = amount;
	}
	
	@Override
	public User getUser() {
		return user;
	}
	
	@Override
	public boolean submit() {
		String oldLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
		if(user.getCreditCard().withdraw(amount)) {
			System.out.println("Withdrawed "+ amount + "$ from creditcard number "+user.getCreditCard().getCreditCardNumber());
			user.getWallet().addFund(amount);
			String newLine = user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
			try {
				fh.appendInFile("walletTransactions.txt", user.getUserName() +" "+ amount);	
				fh=new FileHandler();
				fh.replaceLine("users.txt", oldLine,newLine );
			}catch(IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		System.out.println("Insufficient money in creditcard x(");
		return false;
	}
}
