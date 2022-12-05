package MobileInternetFactory;

import java.util.HashMap;

public interface IMobileRecharge {
	public String serviceName = "Mobile-Recharge";
	public double getTotalAmount();
	public String getProviderName();
	public String getServiceName();
	public HashMap<String,String> getRequirements();
}
