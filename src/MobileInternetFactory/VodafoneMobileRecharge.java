package MobileInternetFactory;

import java.util.HashMap;

import Handlers.ServiceHandler;

public class VodafoneMobileRecharge implements IMobileRecharge{
	private String providerName = "Vodafone-Mobile-Recharge";
	private double taxes = 0.037;	//2% taxes
	private double serviceFunds = 0.009;		//other services funds 1%
	private double amount;
	private String [] requirements= {"Phone number","Amount"};
	private ServiceHandler handler= new ServiceHandler();
	
	@Override
	public HashMap<String,String> getRequirements(){
		HashMap<String,String> map = handler.getAmountFromRequirements(requirements);
		amount =  Double.parseDouble(map.get(requirements[requirements.length-1]));
		return map;
	}
	
	@Override
	public String getProviderName() {
		return providerName;
	}
	
	@Override
	public String getServiceName() {
		return serviceName;
	}
	
	@Override
	public double getTotalAmount() {
		return amount+(amount*serviceFunds+amount*taxes);
	}

}
