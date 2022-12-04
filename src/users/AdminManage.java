package users;

import java.io.FileNotFoundException;

import fawryDemo.FileHandler;

public class AdminManage implements IPersonManage{
	private Admin a;
	private FileHandler fH= new FileHandler();
	
	AdminManage(Admin a){
		this.a=a;
	}
	
	@Override
	public boolean signIn() throws FileNotFoundException {
		if(fH.checkPersonInFile("admins.txt", a)) {
			a.setIsLoggedIn(true);
			return true;
		}
		return false;
	}
	
	@Override
	public void signOut() {
		a.setIsLoggedIn(false);
	}

}