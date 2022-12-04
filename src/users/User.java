package users;

import fawryDemo.Wallet;

public class User implements IPerson {
	private String userName,email,password;
	boolean isLoggedIn;
	private Wallet wallet;
	
	public User(){
		this.email="";
		this.password="";
		this.userName="";
		this.isLoggedIn = false;
	}
	
	public User(String userName,String email,String password){
		this.email=email;
		this.password=password;
		this.userName=userName;
		this.isLoggedIn = false;
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