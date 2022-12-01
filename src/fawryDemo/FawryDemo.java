package fawryDemo;

import java.io.IOException;

public class FawryDemo {

	public static void main(String[] args) throws IOException{
		IServiceFactory f = new InternetPaymentFactory();
		IService m= f.createService();
		m=new SpecificDiscount(m, 10);
		m=new SpecificDiscount(m, 20);
		System.out.println(m.getAmount());
		System.out.println(m.getServiceName());
	}
}