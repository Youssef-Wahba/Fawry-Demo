package fawryDemo;

import MobileInternetFactory.VodafoneInternetPayment;
import MobileInternetFactory.VodafoneMobileRecharge;
import users.User;
import users.UserManage;

import java.io.FileNotFoundException;
import java.util.HashMap;

import MobileInternetFactory.IMobileInternetFactory;
import MobileInternetFactory.InternetPaymentFactory;
import MobileInternetFactory.MobileRechargeFactory;

public class FawryDemo {
		
	public static void main(String[] args) throws FileNotFoundException{
//		IMobileInternetFactory f=new InternetPaymentFactory();
//		VodafoneInternetPayment s=  (VodafoneInternetPayment) f.createVodafoneService();
//		HashMap<String,String> map=s.getRequirements();
//		System.out.println(s.getTotalAmount());
//		System.out.println(map);
//		System.out.println(map.get("Amount"));
		
//		IMobileInternetFactory f2=new MobileRechargeFactory();
//		VodafoneMobileRecharge s2=  (VodafoneMobileRecharge) f2.createVodafoneService();
//		s2.getRequirements();
//		System.out.println(s2.getTotalAmount());
		
		UserManage u = new UserManage(new User());
		HashMap<String,String> map=u.searchService("donation");
		map.forEach((k,v)->System.out.println(k+" : "+v));
//		System.out.println(map);
		System.out.println(map.size());
		
		
		
		
	}
}