package DonationFactory;

import java.util.HashMap;

import Handlers.ServiceHandler;

public class CancerDonation implements IDonation{
	private String ServiceName = "Cancer-Donation";
	private double taxes = 0.017;	//2% taxes
	private double serviceFunds = 0.003;		//other services funds 1%
	private double amount;
	private String [] requirements= {"Organization Name","Amount"};
	private ServiceHandler handler= new ServiceHandler();
	
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
