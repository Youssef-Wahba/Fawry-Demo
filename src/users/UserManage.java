package users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Handlers.FileHandler;

public class UserManage implements IPersonManage{

	private User u;
	private FileHandler fH= new FileHandler();
	
	public UserManage(User u) {
		this.u=u;
	}

	@Override
	public void signOut() {
		u.setIsLoggedIn(false);
	}
	
	@Override
	public boolean signIn() throws FileNotFoundException{
		if(fH.checkPersonInFile("users.txt", u)) {
			u.setIsLoggedIn(true);
			return true;
		}
		return false;
	}

	public boolean signUp() throws IOException{
		if(!fH.checkUserInFile("users.txt", u)) {
			fH.appendInFile("users.txt", u.getUserName()+" "+u.getEmail()+" "+u.getPassword()+" "+u.getCreditCard().getCreditCardNumber()+" "+u.getCreditCard().getAmount()+" "+u.getWallet().getAmount());
			return true;
		}
		return false;
	}
	
	public ArrayList<String> searchService(String serviceName) throws FileNotFoundException{
		return fH.checkServiceInFile("services.txt", serviceName.toLowerCase());
	}
}

