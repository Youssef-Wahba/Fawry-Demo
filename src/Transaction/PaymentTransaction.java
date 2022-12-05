package Transaction;

import java.io.IOException;
import java.util.HashMap;

import DonationFactory.IDonation;
import Handlers.FileHandler;
import MobileInternetFactory.IMobileRecharge;
import MobileInternetFactory.IInternetPayment;
import landlineFactory.ILandlineReciept;
import users.User;

public class PaymentTransaction implements ITransaction {
	private User user;
	private IInternetPayment internetPayment = null;
	private IMobileRecharge mobileRecharge = null;
	private ILandlineReciept landline = null;
	private IDonation donation= null;
	private FileHandler fH = new FileHandler();
	
	public PaymentTransaction(User user) {
		this.user=user;
	}
	
	public void setInternetPayment(IInternetPayment internetPayment) {
		this.internetPayment = internetPayment;
	}
	
	public void setMobileRecharge(IMobileRecharge mobileRecharge) {
		this.mobileRecharge = mobileRecharge;
	}
	
	public void setDonation(IDonation donation) {
		this.donation = donation;
	}
	
	
	public void setLandline(ILandlineReciept landline) {
		this.landline = landline;
	}
	

	@Override
	public User getUser() {
		return user;
	}
	
	@Override
		public boolean submit() {
		if(internetPayment !=null) {
			HashMap<String,String> map=	internetPayment.getRequirements();
			double amount = internetPayment.getTotalAmount();
			System.out.println("Total amount : " + amount);
			String oldLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
			if(user.getCreditCard().withdraw(amount)) {
				System.out.println("Withdrawal "+amount+"$ from creditcard number"+user.getCreditCard()+" success)");
				try {
					String newLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
					fH.appendInFile("paymentTransactions.txt", user.getUserName() + " " + internetPayment.getServiceName()+"  "+internetPayment.getProviderName() + " "  + user.getCreditCard().getPaymentName().toLowerCase() +" "+ amount);	
					fH.replaceLine("users.txt", oldLine, newLine);
				}catch(IOException e) {
					e.printStackTrace();
				}	
				return true;
			}else if(user.getWallet().withdraw(amount)) {
				System.out.println("unsuccessful creditcard withdrawal");
				System.out.println("Withdrawal "+amount+"$ from Wallet successfully :)");
				try {
					String newLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
					fH.appendInFile("paymentTransactions.txt", user.getUserName() + " " + internetPayment.getServiceName()+ " "+ internetPayment.getProviderName() +" "+ user.getWallet().getPaymentName().toLowerCase()+" "+ amount);	
					fH.replaceLine("users.txt", oldLine, newLine);
				}catch(IOException e) {
					e.printStackTrace();
				}				
			}
			else {
				System.out.println("Insufficient money in creditcard or wallet x(");
				internetPayment = null;
				return false;
			}
			internetPayment = null;
			return true;
		}
		else if(mobileRecharge !=null) {
			HashMap<String,String> map=	mobileRecharge.getRequirements();
			double amount = mobileRecharge.getTotalAmount();
			System.out.println("Total amount : " + amount);
			String oldLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
			if(user.getCreditCard().withdraw(amount)) {
				System.out.println("Withdrawal "+amount+"$ from creditcard number"+user.getCreditCard()+" success)");
				try {
					String newLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
					fH.appendInFile("paymentTransactions.txt", user.getUserName() + " " + mobileRecharge.getServiceName()+"  "+mobileRecharge.getProviderName() + " "  + user.getCreditCard().getPaymentName().toLowerCase() +" "+ amount);	
					fH.replaceLine("users.txt", oldLine, newLine);
				}catch(IOException e) {
					e.printStackTrace();
				}	
				return true;
			}else if(user.getWallet().withdraw(amount)) {
				System.out.println("unsuccessful creditcard withdrawal");
				System.out.println("Withdrawal "+amount+"$ from Wallet successfully :)");
				try {
					String newLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
					fH.appendInFile("paymentTransactions.txt", user.getUserName() + " " + mobileRecharge.getServiceName()+ " "+ mobileRecharge.getProviderName() +" "+ user.getWallet().getPaymentName().toLowerCase()+" "+ amount);	
					fH.replaceLine("users.txt", oldLine, newLine);
				}catch(IOException e) {
					e.printStackTrace();
				}				
			}
			else {
				System.out.println("Insufficient money in creditcard or wallet x(");
				mobileRecharge = null;
				return false;
			}
			mobileRecharge = null;
			return true;
		}
		else if(landline != null) {
			HashMap<String,String> map=	landline.getRequirements();
			double amount = landline.getTotalAmount();
			System.out.println("Total amount : " + amount);
			String oldLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
			if(user.getCreditCard().withdraw(amount)) {
				System.out.println("Withdrawal "+amount+"$ from creditcard number"+user.getCreditCard()+" success)");
				try {
					String newLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
					fH.appendInFile("paymentTransactions.txt", user.getUserName() + " " + landline.getServiceName()+"  "+landline.getProviderName() + " "  + user.getCreditCard().getPaymentName().toLowerCase()+" "+map.get("Landline Number") +" "+ amount);	
					fH.replaceLine("users.txt", oldLine, newLine);
				}catch(IOException e) {
					e.printStackTrace();
				}	
				return true;
			}else if(user.getWallet().withdraw(amount)) {
				System.out.println("unsuccessful creditcard withdrawal");
				System.out.println("Withdrawal "+amount+"$ from Wallet successfully :)");
				try {
					String newLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
					fH.appendInFile("paymentTransactions.txt", user.getUserName() + " " + landline.getServiceName()+ " "+ landline.getProviderName() +" "+ user.getWallet().getPaymentName().toLowerCase()+" "+map.get("Landline Number") +" "+ amount);
					fH.replaceLine("users.txt", oldLine, newLine);
				}catch(IOException e) {
					e.printStackTrace();
				}				
			}
			else {
				System.out.println("Insufficient money in creditcard or wallet x(");
				landline = null;
				return false;
			}
			landline = null;
			return true;
		}
		else if(donation != null){
			HashMap<String,String> map=	donation.getRequirements();
			double amount = donation.getTotalAmount();
			System.out.println("Total amount : " + amount);
			String oldLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
			if(user.getCreditCard().withdraw(amount)) {
				System.out.println("Withdrawal "+amount+"$ from creditcard number"+user.getCreditCard()+" success)");
				try {
					String newLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
					fH.appendInFile("paymentTransactions.txt", user.getUserName() + " " + donation.getServiceName()+"  "+donation.getProviderName() + " "  + user.getCreditCard().getPaymentName().toLowerCase()+" " + map.get("Organization Name") +" "+ amount);	
					fH.replaceLine("users.txt", oldLine, newLine);
				}catch(IOException e) {
					e.printStackTrace();
				}	
				return true;
			}else if(user.getWallet().withdraw(amount)) {
				System.out.println("unsuccessful creditcard withdrawal");
				System.out.println("Withdrawal "+amount+"$ from Wallet successfully :)");
				try {
					String newLine=user.getUserName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getCreditCard().getCreditCardNumber()+" "+user.getCreditCard().getAmount()+" "+user.getWallet().getAmount();
					fH.appendInFile("paymentTransactions.txt", user.getUserName() + " " + donation.getServiceName()+"  "+donation.getProviderName() + " "  + user.getCreditCard().getPaymentName().toLowerCase()+" " + map.get("Organization Name") +" "+ amount);	
					fH.replaceLine("users.txt", oldLine, newLine);
				}catch(IOException e) {
					e.printStackTrace();
				}				
			}
			else {
				System.out.println("Insufficient money in creditcard or wallet x(");
				donation = null;
				return false;
			}
			donation = null;
			return true;
		}
		else {
			System.out.println("No service selected or set");
			return false;
		}
	}
}
