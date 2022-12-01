package fawryDemo;

import java.io.FileNotFoundException;

public interface IPersonManage {
	public boolean signIn() throws FileNotFoundException;
	public void signOut();
}
