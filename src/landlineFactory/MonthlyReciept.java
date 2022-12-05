package landlineFactory;

import java.util.HashMap;

import Handlers.ServiceHandler;

public class MonthlyReciept implements ILandlineReciept{

	private String ServiceName = "Monthly-Landline-Reciept";
	private double taxes = 0.017;	// 3.7% taxes
	private double serviceFunds = 0.007;		//other services funds 0.9%
	private double amount = 0;
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
		amount=(double)Math.floor(Math.random()*(150-50+1)+50);
		return amount+(amount*serviceFunds+amount*taxes);
	}
	
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	
	public String getLandlineNumber() {
		return landlineNumber;
	}
}
