package MobileInternetFactory;

import java.util.HashMap;

import Discount.IApplyDiscount;

public class VodafoneMobileRecharge implements IVodafoneService{
	private String ServiceName = "Vodafone Mobile Recharge";
	private double taxes = 0.037;	//2% taxes
	private double serviceFunds = 0.009;		//other services funds 1%
	private double amount;
	private String [] requirements= {"Phone number","Amount"};
	ServiceHandler handler= new ServiceHandler();
	
	@Override
	public HashMap<String,String> getRequirements(){
		HashMap<String,String> map = handler.getAmountFromRequirements(requirements);
		amount =  Double.parseDouble(map.get(requirements[requirements.length-1]));
		return map;
	}
	
	@Override
	public String getProviderName() {
		return ProviderName;
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
