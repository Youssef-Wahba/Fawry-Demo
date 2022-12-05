package landlineFactory;

import java.util.HashMap;

import Handlers.ServiceHandler;

public class QuarterReciept implements ILandlineReciept{

	private String ServiceName = "Quarter-Landline-Reciept";
	private double taxes = 0.037;	// 3.7% taxes
	private double serviceFunds = 0.01;		//other services funds 0.9%
	private double amount;
	private String [] requirements= {"Landline Number"};
	private String landlineNumber="";
	ServiceHandler handler= new ServiceHandler();

	@Override
	public String getProviderName() {
		return providerName ;
	}

	@Override
	public String getServiceName() {
		return ServiceName;
	}

	@Override
	public HashMap<String, String> getRequirements() {
		HashMap<String,String> map = handler.getAmountFromRequirements(requirements);
		landlineNumber=map.get("Landline Number");
		return map;
	}

	@Override
	public double getTotalAmount() {
		for(int i=0;i<landlineNumber.length();i++) {
			if(Character.isDigit(landlineNumber.charAt(i))) {
				String s="";
				s += landlineNumber.charAt(i);
				amount += Double.parseDouble(s)*3;
				s = "";
			}
		}
		return amount+(amount*serviceFunds+amount*taxes);
	}
}