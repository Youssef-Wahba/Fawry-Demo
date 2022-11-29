package fawryDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserManage {

	public boolean signInUser(User u) {
		boolean flag=false;
		try {
			Scanner reader =new Scanner(new File("users.txt"));
			String check;
			while(reader.hasNextLine()) {
				check=reader.nextLine();
				String[] userArr =check.split(" ");
				if(userArr[1].equals(u.getEmail())) {
					if(userArr[2].equals(u.getPassword())) {
						flag=true;
						break;
					}else {
						System.out.println("incorrect password");
						break;
					}
				}
			}
		}catch (FileNotFoundException e) {
			System.out.println("\nError in accessing file x(\n");
			e.printStackTrace();
		}
		return flag;		
	}

	public boolean signUpUser(User u) {
		boolean flag=false;
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter("users.txt",true));
			Scanner reader =new Scanner(new File("users.txt"));
			String check;
			boolean flag2=true;
			while(reader.hasNext()) {
				check=reader.nextLine();
				String[] userArr =check.split(" ");
				if(userArr[0].equals(u.getUserName())) {
					System.out.println("Username already exists");
					flag2=false;
					break;
				}
				if(userArr[1].equals(u.getEmail())) {
					System.out.println("email already exists");
					flag2=false;
					break;
				}
			}
			reader.close();
			if(flag2) {
				writer.write(u.getUserName()+" "+u.getEmail()+" "+u.getPassword()+"\n");
				writer.close();
				System.out.println("Signed up");
				flag=true;
			}
		}catch(IOException e) {
			System.out.println("\nError in accessing file x(\n");
			e.printStackTrace();
		}
		return flag;
	
	}
}
