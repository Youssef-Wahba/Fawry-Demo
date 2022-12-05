package Handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import PaymentMethod.CreditCard;
import PaymentMethod.Wallet;
import users.Admin;
import users.User;

public class FileHandler {
	
	public void appendInFile(String fileName,String s) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
		writer.write(s+"\n");
		writer.close();
	}
//	for sign in
	public boolean checkPersonInFile(String fileName, User u ) throws FileNotFoundException {
		boolean flag=false;
		Scanner reader =new Scanner(new File(fileName));
		String check;
		while(reader.hasNextLine()) {
			check=reader.nextLine();
			String[] userArr =check.split(" ");
			if(userArr[1].equals(u.getEmail())) {
				if(userArr[2].equals(u.getPassword())) {
					flag=true;
					u.setUserName(userArr[0]);
					CreditCard  c =new CreditCard(userArr[3],Double.parseDouble(userArr[4]));
					Wallet  w =new Wallet(Double.parseDouble(userArr[5]));
					u.setCreditCard(c);
					u.setWallet(w);
					return flag;
				}else {
					return flag;
				}
			}
		}
		return flag;
	}
//	sign up
	public boolean checkUserInFile(String fileName, User u)throws FileNotFoundException{
		boolean flag=false;
		Scanner reader =new Scanner(new File(fileName));
		String check;
		while(reader.hasNextLine()) {
			check=reader.nextLine();
			String[] userArr =check.split(" ");
			if(userArr[0].equals(u.getUserName())) {
				flag = true;
				return flag;
			}
			if(userArr[1].equals(u.getEmail())) {
				flag = true;
				return flag;
			}			
		}
		return flag;
	}
	
	public boolean checkAdminInFile (String fileName, Admin a)throws FileNotFoundException{
		boolean flag=false;
		Scanner reader =new Scanner(new File(fileName));
		String check;
		while(reader.hasNextLine()) {
			check=reader.nextLine();
			String[] adminArr =check.split(" ");
			if(adminArr[1].equals(a.getEmail())) {
				if(adminArr[2].equals(a.getPassword())) {
					flag=true;
					return flag;
				}else {
					return flag;
				}
			}
		}
		return flag;
	}
	public HashMap<String,String> checkServiceInFile(String fileName,String serviceName)throws FileNotFoundException{
		HashMap<String,String> map=new HashMap<String,String>();
		Scanner reader =new Scanner(new File(fileName));
		String check;
		while(reader.hasNextLine()) {
			check=reader.nextLine();
			String[] servicesArray=check.split(" ");
			for(int i=1;i<servicesArray.length;i++) {
				String s=servicesArray[i].toLowerCase();
				if(s.contains(serviceName)) {
					map.put(servicesArray[0], servicesArray[i]);
				}
			}
		}
		return map;
	}
	
	public void replaceLine(String fileName,String oldLine,String newLine) {
		ArrayList<String> fileLines=new ArrayList<String>();
		try {
			Scanner reader=new Scanner(new File(fileName));
			String check;
			while(reader.hasNext()) {
				check=reader.nextLine();
				if(check.equals(oldLine)) {
					fileLines.add(newLine);
					continue;
				}
				fileLines.add(check);
			}
			BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
			Iterator<String> iterator=fileLines.iterator();
			writer.flush();
			writer.close();
			while(iterator.hasNext()) {
				new FileHandler().appendInFile(fileName, iterator.next());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
