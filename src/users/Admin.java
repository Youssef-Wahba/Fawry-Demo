package users;

public class Admin implements IPerson{
	private String userName,password,email;
	private boolean isLoggedIn;
	Admin(){
		this.email = "";
		this.isLoggedIn = false;
		this.password = "";
		this.userName = "";
	}
	Admin(String userName,String email, String password){
		this.email = email;
		this.isLoggedIn = false;
		this.password = password;
		this.userName = userName;
	}
	@Override
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public boolean getIsLoggedIn() {
		return this.isLoggedIn;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public String getUserName() {
		return this.userName;
	}
	
	@Override
	public void setEmail(String email) {
		this.email=email;
	}
	
	@Override
	public void setIsLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn=isLoggedIn;		
	}
	
	@Override
	public void setPassword(String password) {
		this.password=password;	
	}
	
	@Override
	public void setUserName(String userName) {
		this.userName=userName;	
	}
}
