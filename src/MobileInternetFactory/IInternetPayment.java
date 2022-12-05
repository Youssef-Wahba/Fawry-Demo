package MobileInternetFactory;

import java.util.HashMap;

public interface IInternetPayment {
	public String serviceName = "Internet-Payment";
	public double getTotalAmount();
	public String getProviderName();
	public String getServiceName();
	public HashMap<String,String> getRequirements();
}
