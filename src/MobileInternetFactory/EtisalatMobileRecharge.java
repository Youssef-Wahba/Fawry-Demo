package MobileInternetFactory;

import java.util.HashMap;

public class EtisalatMobileRecharge implements IEtisalatService{
	private String ServiceName = "Etisalat-Mobile-Recharge";
	private double taxes = 0.037;	// 3.7% taxes
	private double serviceFunds = 0.009;		//other services funds 0.9%
	private double amount;
	private String [] requirements= {"Phone number","Amount"};
	ServiceHandler handler= new ServiceHandler();
	
	@Override
	public String getProviderName() {
		return ProviderName;
	}
	
	@Override
	public HashMap<String, String> getRequirements() {
		HashMap<String,String> map = handler.getAmountFromRequirements(requirements);
		amount =  Double.parseDouble(map.get(requirements[requirements.length-1]));
		return map;
	}
	
	@Override
	public String getServiceName() {
		return ServiceName;
	}
	
	@Override
	public double getTotalAmount() {
		return amount+(amount*serviceFunds+amount*taxes);
	}
}
