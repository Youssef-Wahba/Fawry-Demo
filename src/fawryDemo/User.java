package fawryDemo;

public class User {
	private String userName,email,password;
	
	User(){
		this.email="";
		this.password="";
		this.userName="";
	}
	
	User(String userName,String email,String password){
		this.email=email;
		this.password=password;
		this.userName=userName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUserName() {
		return userName;
	}
}