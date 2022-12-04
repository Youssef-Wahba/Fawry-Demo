package users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import fawryDemo.FileHandler;

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
		if(!fH.checkPersonInFile("users.txt", u)) {
			fH.appendInFile("users.txt", u.getUserName()+" "+u.getEmail()+" "+u.getPassword());
			return true;
		}
		return false;
	}
	public HashMap<String, String> searchService(String serviceName) throws FileNotFoundException{
		return fH.checkServiceInFile("services.txt", serviceName.toLowerCase());
	}
}

