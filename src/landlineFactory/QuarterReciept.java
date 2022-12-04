package landlineFactory;

import java.util.HashMap;

import Handlers.ServiceHandler;

public class QuarterReciept implements ILandlineReciept{

	private String ServiceName = "Quarter-Landline-Reciept";
	private double taxes = 0.037;	// 3.7% taxes
	private double serviceFunds = 0.01;		//other services funds 0.9%
	private double amount;
	private String [] requirements= {"Landline Number","Amount"};

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
		amount=Double.parseDouble(map.get("Amount"));
		return map;
	}

	@Override
	public double getTotalAmount() {
		return amount+(amount*serviceFunds+amount*taxes);
	}
}