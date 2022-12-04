package MobileInternetFactory;

import java.util.HashMap;

public class VodafoneInternetPayment implements IVodafoneService{
	private String ServiceName = "Vodafone Internet Payment";
	private double taxes = 0.02;	//2% taxes
	private double serviceFunds = 0.01;		//other services funds 1%
	private double amount;
	private String [] requirements= {"Telephone number","Amount"};
	ServiceHandler handler= new ServiceHandler();
	
	@Override
	public HashMap<String,String> getRequirements(){
		HashMap<String,String> map = handler.getAmountFromRequirements(requirements);
		amount =  Double.parseDouble(map.get(requirements[requirements.length-1]));
		return map;
	}
	
	@Override
	public double getTotalAmount() {
		return amount+(amount*serviceFunds+amount*taxes);
	}
	
	@Override
	public String getProviderName() {
		return ProviderName;
	}
	@Override
	public String getServiceName() {
		return ServiceName;
	}

}
