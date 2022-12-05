package Handlers;

import java.util.HashMap;
import java.util.Scanner;

public class ServiceHandler {
	
	public void printResponse(HashMap<String,String> m) {
		 for (String i : m.keySet()) {
		     System.out.println(i + " : " + m.get(i));
		 }
	}
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
