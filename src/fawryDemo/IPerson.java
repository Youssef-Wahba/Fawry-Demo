package fawryDemo;

public interface IPerson {
	public void setUserName(String userName);
	public void setEmail(String email);
	public void setPassword(String password);
	public void setIsLoggedIn(boolean isLoggedIn);
	public String getUserName();
	public String getEmail();
	public String getPassword();
	public boolean getIsLoggedIn();
}
