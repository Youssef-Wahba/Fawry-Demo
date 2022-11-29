package fawryDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserManage {
//	private User u;
//	
//	public UserManage(User u){
//		this.u=u;
//	}
	
	public boolean signInUser(User u) {
		boolean flag=false;
		try {
			BufferedReader reader =new BufferedReader (new FileReader("users.txt"));
			String check;
			while((check=reader.readLine())!=null) {
				String userArr []=check.split(" ");
				System.out.println(userArr[0]+" "+userArr[1]+" "+userArr[2]);
				System.out.println(u.getEmail()+" "+u.getPassword());
				if(userArr[1] == u.getEmail()) {
					System.out.println("1111111");
					if(userArr[2] == u.getPassword()) {
						System.out.println("logged in");
						flag=true;
					}else System.out.println("incorrect password");
				}else {
					System.out.println("asdasdasd");
				}
			}
		}catch (IOException e) {
			System.out.println("\nError in accessing file x(\n");
			e.printStackTrace();
		}
		return flag;		
	}

	public boolean signUpUser(User u) {
		boolean flag=false;
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter("users.txt",true));
			BufferedReader reader =new BufferedReader (new FileReader("users.txt"));
			String check;
			boolean flag2=true;
			StringBuilder builder =new StringBuilder();
			while((check=reader.readLine())!=null) {
				builder.append(check);
				String[] userArr = builder.toString().split(" ");
				System.out.println(userArr[0]+" "+userArr[1]+" "+userArr[2]);
				if(userArr[0].toString()==u.getUserName()) {
					System.out.println("Username already exists");
					flag2=false;
					break;
				}
				if(userArr[1] == u.getEmail()) {
					System.out.println("email already exists");
					flag2=false;
					break;
				}
				builder.delete(0, builder.length()-1);
			}
//			if(flag2) {
//				writer.write(u.getUserName()+" "+u.getEmail()+" "+u.getPassword()+"\n");
//				writer.close();
//				System.out.println("Signed up");
//				flag=true;
//			}
		}catch(IOException e) {
			System.out.println("\nError in accessing file x(\n");
			e.printStackTrace();
		}
		return flag;
	
	}
}
