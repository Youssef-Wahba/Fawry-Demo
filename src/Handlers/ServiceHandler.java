package Handlers;

import java.util.HashMap;
import java.util.Scanner;

public class ServiceHandler {
	
	public HashMap<String,String> getAmountFromRequirements(String [] req) {
		HashMap<String, String> map=new HashMap<String,String>();
		Scanner in =new Scanner(System.in);
		for(int i=0;i<req.length;i++) {
			System.out.print(req[i]+" : ");
			map.put(req[i], in.nextLine());
		}
		System.out.println("asdasd");
		return map;
	}
	
}
