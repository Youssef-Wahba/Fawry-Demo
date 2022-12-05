package users;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import Handlers.FileHandler;

public class AdminManage implements IPersonManage{
	private Admin a;
	private FileHandler fH= new FileHandler();
	
	public AdminManage(Admin a){
		this.a=a;
	}
	
	@Override
	public boolean signIn() throws FileNotFoundException {
		if(fH.checkAdminInFile("admins.txt", a)) {
			a.setIsLoggedIn(true);
			return true;
		}
		return false;
	}
	
	@Override
	public void signOut() {
		a.setIsLoggedIn(false);
	}
	public void listAllPayment() throws FileNotFoundException{
		ArrayList<String> list=fH.printAll("paymentTransactions.txt");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("\tUsername\tService Name\tProvider Name\tPayment method\t amount");
		System.out.println("----------------------------------------------------------------------------------------");
		Iterator<String> iterator=list.iterator();
		int counter=0;
		while(iterator.hasNext()) {
			counter++;
			String[] s=iterator.next().split(" ");
			System.out.print(counter+" ");
			for(int i=0;i<s.length;i++) {
				System.out.print(s[i]+"\t");
			}
			System.out.print("\n");
		}
		
	}
	public void listAllWalletFunds()throws FileNotFoundException{
		ArrayList<String> list=fH.printAll("walletTransactions.txt");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println(" Username\t amount");
		System.out.println("----------------------------------------------------------------------------------------");
		Iterator<String> iterator=list.iterator();
		int counter=0;
		while(iterator.hasNext()) {
			counter++;
			String[] s=iterator.next().split(" ");
			System.out.print(counter+" ");
			for(int i=0;i<s.length;i++) {
				System.out.print(s[i]+"\t");
			}
			System.out.print("\n");
		}
	}

}
