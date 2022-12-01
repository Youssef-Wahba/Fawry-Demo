package fawryDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
	
	public void appendInFile(String fileName,String s) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
		writer.write(s+"\n");
		writer.close();
	}
	
	public boolean checkPersonInFile(String fileName, IPerson u ) throws FileNotFoundException {
		boolean flag=false;
		Scanner reader =new Scanner(new File(fileName));
		String check;
		while(reader.hasNextLine()) {
			check=reader.nextLine();
			String[] userArr =check.split(" ");
			if(userArr[1].equals(u.getEmail())) {
				if(userArr[2].equals(u.getPassword())) {
					flag=true;
					return flag;
				}else {
					return flag;
				}
			}
		}
		return flag;
	}
}
